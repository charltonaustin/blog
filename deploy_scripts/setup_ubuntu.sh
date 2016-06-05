sudo ufw allow ssh
sudo ufw allow 443/tcp
sudo ufw enable
# need make this automated
sudo dpkg-reconfigure tzdata
sudo apt-get update
sudo apt-get install ntp
sudo fallocate -l 4G /swapfile
sudo chmod 600 /swapfile
sudo mkswap /swapfile
sudo swapon /swapfile
# need to make this idempotent
sudo sh -c 'echo "/swapfile none swap sw 0 0" >> /etc/fstab'
