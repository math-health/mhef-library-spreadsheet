#!/bin/sh

# Preview Table CSV
# $ `./src/shell/preview-table-csv.sh ./assets/content/cities.csv`

##############################
# Declaring the variables
##############################

AUX_01="$1"

##############################
# Functions
##############################

display_file_csv_as_table_raw() {
	PATH_FILE_CSV="$1"

    # Read the first line of the CSV file to get the column headers
    read -r header < "$PATH_FILE_CSV"

    # Find the maximum length for each column
    column_count=$(awk -F',' '{print NF; exit}' "$PATH_FILE_CSV")
    max_lengths=()

    for ((i=1; i<=column_count; i++)); do
        max_length=$(awk -F',' -v column="$i" 'length($column) > max_length { max_length = length($column) } END { print max_length }' "$PATH_FILE_CSV")
        max_lengths+=("$max_length")
    done

    # Print the header using awk
    echo "$header" | awk -F',' -v widths="$(IFS=,; echo "${max_lengths[*]}")" 'BEGIN { split(widths, widths_arr, ",") } { for(i=1; i<=NF; i++) printf "%-*s ", widths_arr[i], $i; printf "\n" }'

    # Print the remaining rows using awk
    awk -F',' -v widths="$(IFS=,; echo "${max_lengths[*]}")" 'BEGIN { split(widths, widths_arr, ",") } NR>1 { for(i=1; i<=NF; i++) { if ($i == "" || $i == "NULL") printf "\033[0;31m%-*s\033[0m ", widths_arr[i], "NULL"; else printf "%-*s ", widths_arr[i], $i; } printf "\n" }' "$PATH_FILE_CSV"
}

display_file_csv_as_table_highlight() {
    PATH_FILE_CSV="$1"

    # Read the first line of the CSV file to get the column headers
    read -r header < "$PATH_FILE_CSV"

    # Find the maximum length for each column
    column_count=$(awk -F',' '{print NF; exit}' "$PATH_FILE_CSV")
    max_lengths=()

    for ((i=1; i<=column_count; i++)); do
        max_length=$(awk -F',' -v column="$i" 'length($column) > max_length { max_length = length($column) } END { print max_length }' "$PATH_FILE_CSV")
        max_lengths+=("$max_length")
    done

    # Print the header using awk
    echo "$header" | awk -F',' -v widths="$(IFS=,; echo "${max_lengths[*]}")" 'BEGIN { split(widths, widths_arr, ",") } { for(i=1; i<=NF; i++) printf "%-*s ", widths_arr[i], $i; printf "\n" }'

    # Print the remaining rows using awk
    awk -F',' -v widths="$(IFS=,; echo "${max_lengths[*]}")" '
    BEGIN { split(widths, widths_arr, ",") }
    NR > 1 {
        for(i=1; i<=NF; i++) {
            if ($i == "" || $i == "NULL" || $i ~ /^ *$/) {
                printf "\033[0;31m%-*s\033[0m ", widths_arr[i], "NULL"
            } else {
                printf "%-*s ", widths_arr[i], $i
            }
        }
        printf "\n"
    }' "$PATH_FILE_CSV"
}

##############################
# Calling the functions
##############################

# Check if a filename is provided as an argument
if [ $# -eq 0 ]; then
    echo "Please provide the filename as an argument."
    exit 1
fi

# Check if the file exists
if [ ! -f "$AUX_01" ]; then
    echo "File $AUX_01 does not exist."
    exit 1
fi

#display_file_csv_as_table_raw "$AUX_01"
display_file_csv_as_table_highlight "$AUX_01"