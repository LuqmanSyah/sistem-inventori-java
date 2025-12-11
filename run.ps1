# PowerShell Script untuk Compile dan Run Java Project
# Source folder: src
# Output folder: bin
# Usage: ./run.ps1 [NamaFile.java]

param(
    [Parameter(Position=0)]
    [string]$JavaFile
)

# Konfigurasi path
$ProjectRoot = $PSScriptRoot
$SrcDir = Join-Path $ProjectRoot "src"
$BinDir = Join-Path $ProjectRoot "bin"
$LibDir = Join-Path $ProjectRoot "lib"

# Cek apakah file Java diberikan
if (-not $JavaFile) {
    Write-Host "Usage: ./run.ps1 <NamaFile.java>" -ForegroundColor Yellow
    Write-Host "Contoh: ./run.ps1 App.java" -ForegroundColor Gray
    Write-Host ""

    # Tampilkan file Java yang tersedia
    Write-Host "File Java yang tersedia di folder src:" -ForegroundColor Cyan
    $JavaFiles = Get-ChildItem -Path $SrcDir -Filter "*.java" -Recurse -File
    foreach ($file in $JavaFiles) {
        $relativePath = $file.FullName.Substring($SrcDir.Length + 1)
        Write-Host "  - $relativePath" -ForegroundColor Gray
    }
    exit 1
}

# Ekstrak nama class dari nama file (hapus .java)
$MainClass = $JavaFile -replace "\.java$", ""

# Jika ada path separator, convert ke format package (ganti \ atau / dengan .)
$MainClass = $MainClass -replace "[\\/]", "."

Write-Host ""
Write-Host "Java Project Builder & Runner" -ForegroundColor Magenta
Write-Host "Project: $ProjectRoot" -ForegroundColor Gray
Write-Host "File: $JavaFile" -ForegroundColor Gray
Write-Host "Class: $MainClass" -ForegroundColor Gray
Write-Host ""

# Fungsi untuk compile
function Compile-Java {
    Write-Host "========================================" -ForegroundColor Cyan
    Write-Host "        COMPILING JAVA PROJECT          " -ForegroundColor Cyan
    Write-Host "========================================" -ForegroundColor Cyan

    # Buat folder bin jika belum ada
    if (-not (Test-Path $BinDir)) {
        New-Item -ItemType Directory -Path $BinDir -Force | Out-Null
        Write-Host "Folder bin dibuat." -ForegroundColor Green
    }

    # Cari semua file .java di folder src (termasuk subfolder)
    $JavaFiles = Get-ChildItem -Path $SrcDir -Filter "*.java" -Recurse -File

    if ($JavaFiles.Count -eq 0) {
        Write-Host "Tidak ada file Java yang ditemukan di folder src!" -ForegroundColor Red
        return $false
    }

    Write-Host "Ditemukan $($JavaFiles.Count) file Java:" -ForegroundColor Yellow
    foreach ($file in $JavaFiles) {
        $relativePath = $file.FullName.Substring($SrcDir.Length + 1)
        Write-Host "  - $relativePath" -ForegroundColor Gray
    }

    # Siapkan classpath untuk library (jika ada)
    $Classpath = $BinDir
    if (Test-Path $LibDir) {
        $JarFiles = Get-ChildItem -Path $LibDir -Filter "*.jar" -File
        if ($JarFiles.Count -gt 0) {
            $LibJars = ($JarFiles | ForEach-Object { $_.FullName }) -join ";"
            $Classpath = "$BinDir;$LibJars"
            Write-Host "Library ditemukan: $($JarFiles.Count) file JAR" -ForegroundColor Yellow
        }
    }

    # Compile semua file Java
    Write-Host "`nMengcompile..." -ForegroundColor Yellow

    $JavaFileList = ($JavaFiles | ForEach-Object { "`"$($_.FullName)`"" }) -join " "

    $CompileCommand = "javac -d `"$BinDir`" -sourcepath `"$SrcDir`" -cp `"$Classpath`" $JavaFileList"

    try {
        Invoke-Expression $CompileCommand 2>&1 | ForEach-Object { Write-Host $_ }

        if ($LASTEXITCODE -eq 0) {
            Write-Host "`nCompile berhasil!" -ForegroundColor Green
            return $true
        } else {
            Write-Host "`nCompile gagal dengan error code: $LASTEXITCODE" -ForegroundColor Red
            return $false
        }
    } catch {
        Write-Host "`nError saat compile: $_" -ForegroundColor Red
        return $false
    }
}

# Fungsi untuk run
function Run-Java {
    param([string]$ClassName)

    Write-Host "`n========================================" -ForegroundColor Cyan
    Write-Host "         RUNNING JAVA PROJECT           " -ForegroundColor Cyan
    Write-Host "========================================" -ForegroundColor Cyan

    # Cek apakah folder bin ada
    if (-not (Test-Path $BinDir)) {
        Write-Host "Folder bin tidak ditemukan. Silakan compile terlebih dahulu!" -ForegroundColor Red
        return
    }

    # Siapkan classpath
    $Classpath = $BinDir
    if (Test-Path $LibDir) {
        $JarFiles = Get-ChildItem -Path $LibDir -Filter "*.jar" -File
        if ($JarFiles.Count -gt 0) {
            $LibJars = ($JarFiles | ForEach-Object { $_.FullName }) -join ";"
            $Classpath = "$BinDir;$LibJars"
        }
    }

    Write-Host "Menjalankan class: $ClassName" -ForegroundColor Yellow
    Write-Host "----------------------------------------" -ForegroundColor Gray

    try {
        $RunCommand = "java -cp `"$Classpath`" $ClassName"
        Invoke-Expression $RunCommand

        Write-Host "----------------------------------------" -ForegroundColor Gray
        if ($LASTEXITCODE -eq 0) {
            Write-Host "Program selesai dengan sukses." -ForegroundColor Green
        } else {
            Write-Host "Program selesai dengan exit code: $LASTEXITCODE" -ForegroundColor Yellow
        }
    } catch {
        Write-Host "Error saat menjalankan program: $_" -ForegroundColor Red
    }
}

# Compile dan Run
$compileResult = Compile-Java
if ($compileResult) {
    Run-Java -ClassName $MainClass
}

Write-Host ""
