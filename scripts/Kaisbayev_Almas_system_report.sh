#!/bin/bash
# System report for Kaisbayev Almas
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
LOG_FILE="$SCRIPT_DIR/../logs/Kaisbayev_Almas_system_report.log"

{
echo "=============================================="
echo "Student System Report"
echo "=============================================="
echo "Student Full Name : Kaisbayev Almas"
echo "Date and Time     : $(date)"
echo "Username          : $(whoami)"
echo "Operating System  : $(uname -s)"
echo "Kernel Version    : $(uname -r)"
echo ""
echo "----- CPU Information -----"
echo "Model : $(grep -m1 'model name' /proc/cpuinfo | cut -d: -f2 | xargs)"
echo "Cores : $(nproc)"
echo ""
echo "----- Memory Information -----"
free -h
echo ""
echo "----- Disk Usage -----"
df -h /
echo ""
echo "Available disk space on / : $(df -h / | awk 'NR==2 {print $4}')"
echo "=============================================="
} | tee "$LOG_FILE"
