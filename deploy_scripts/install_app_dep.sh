echo oracle-java8-installer shared/accepted-oracle-license-v1-1 select true | sudo /usr/bin/debconf-set-selections
sudo add-apt-repository ppa:webupd8team/java
sudo apt-get update
sudo apt-get install -y nginx supervisor git oracle-java8-installer
sudo mkdir -p /var/blog/ 

update-rc.d nginx defaults
