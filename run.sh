#!/bin/bash

spinner=('|' '/' '-' '\\')
i=0
duration=2  # Duration in seconds
start_time=$(date +%s)

while true; do
  current_time=$(date +%s)
  elapsed_time=$((current_time - start_time))
  if [[ "$elapsed_time" -ge "$duration" ]]; then
    echo -e "\rLoading: Done!          " # Clear the line and print "Done!"
    break
  fi
  printf "\rLoading: ${spinner[$((i % ${#spinner[@]}))]}"
  i=$((i + 1))
  sleep 0.1
done

java src.App
