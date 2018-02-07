gource -1920x1080 --auto-skip-seconds 1 --background-image background.jpg --camera-mode track --hide progress --bloom-multiplier 1 --bloom-intensity 1 --title "Made by /GitHub/HealPot" --max-file-lag 2 -o gource.ppm
ffmpeg -y -r 60 -f image2pipe -vcodec ppm -i gource.ppm -vcodec libx264 -preset ultrafast -pix_fmt yuv420p -crf 1 -threads 0 -bf 0 gource.x264.mp4
ffmpeg -i render.avi -c:v libx264 -crf 19 -preset slow -c:a libfdk_aac -b:a 192k -ac 2 out.mp4