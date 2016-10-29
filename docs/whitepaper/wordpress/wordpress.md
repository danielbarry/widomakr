# WordPress Vulnerabilities

Written by B[], 28/10/2016.

## Introduction

In this white paper we would like to discuss several problems found in a recent
analysis of WordPress. Here we will discuss the following vulnerabilities:

  1. `[Low]` PHP error codes
  2. `[Low]` Website directory structure
  3. `[High]` DDoS through low bandwidth connection

### [1] PHP Error Codes

This involves getting error codes to the display by navigating to certain URLs.
The trace of a problem should never appear on the user's display due to it not
being meaningful and potentially revealing information about the back-end.

### [2] Website Directory Structure

Using [1], we can get information about the directory structure from WordPress
- in particular PHP where WordPress fails to run correctly.

### [3] DDoS Through Low Bandwidth Connection

This vulnerability involves attacking a WordPress plug that allows for embedded
content. By causing it to do extreme numbers of database requests, we can lock
out the database entirely for other users on low bandwidth connections.

## Methodology

### Test Environment

The environment used to run the experiment:

  * Virtual Machine Software: VirtualBox 5.0.24
  * Operating System: 16.04.1 LTS (ubuntu-16.04.1-server-amd64.iso)

In Virtual Box, the machine was given the following properties (that are
different from the default):

  * RAM: 512MB
  * Disk: Ubuntu installation CD
  * HDD: 4GB Dynamic VDI
  * Network Adapter 1: NAT
  * Network Adapter 2: Bridged Adapter

**NOTE:** You will have to setup your network to your situation, so that you
have internet access and are able to communicate with the server locally.

We are not providing the VM this was tested on in the hope that individuals
will test these vulnerabilities themselves and confirm them - perhaps changing
variables so that we can gauge in scope. Ubuntu Server was installed with the
following values at installation:

  * `English` (Language)
  * `Install Ubuntu Server` (Boot Menu)
  * `English` (Language)
  * `United Kingdom` (Language)
  * `No` (Detect Keyboard Settings)
  * `English UK` (Keyboard Origin)
  * `English UK` (Keyboard Layout)
  * `Continue` (Not network interface found)
  * `ubuntu` (Hostname)
  * `user` (Username)
  * `user` (Username for account)
  * `password` (Password for Account)
  * `password` (Confirm Password)
  * `No` (Encrypt Home Directory)
  * `Guided - use entire disk and set up LVM` (Partition Disks)
  * `Select only partition` (Which Disk to Partition)
  * `Yes` (Write Changes to Disk)
  * `3.8GB` (Space for Volume)
  * `Yes` (Write Partitions to Disk)
  * `Continue` (Configure Proxy)
  * `No automatic updates` (Update Mechanism)
  * `Manual package selection` (Software Selection)
  * `Yes` (Install GRUB)
  * `Yes` (Reboot After Unmounting Disk)

For the next section, we used the following link for installation instructions:
https://www.liberiangeek.net/2015/06/how-to-install-wordpress-on-ubuntu-15-04-server/

Our first step was to remove an traces of the default software, by running the
following commands:

    sudo apt-get update
    sudo apt-get install apache2
    sudo apt-get install mysql-server mysql-client
    sudo mysql_secure_installation
    sudo apt-get install php7.0 libapache2-mod-php7.0
    sudo apt-get install php7.0-mysql php7.0-curl php7.0-gd php7.0-intl \
    php-pear php7.0-imap php7.0-mcrypt php7.0-pspell php7.0-recode \
    php7.0-snmp php7.0-sqlite3 php7.0-tidy php7.0-xmlrpc php7.0-xsl

Database password: `password`.

### Test Method

For each test, the installation and setup instructions are listed. A clone of
the clean VM is used before the installation instructions are used to prevent
any cross contamination of software, settings and ultimately the results.

Only new and easily accessible versions of PHP and WordPress are used for the
experimentation, as these are the versions expected to be default installed by
persons setting up new web servers.

#### Case 1

    cd /tmp/ && wget http://wordpress.org/latest.tar.gz
    tar -xvzf latest.tar.gz
    sudo mv wordpress/* /var/www/html/
    cd /var/www/html/
    mysql -u root -p
    CREATE DATABASE wpdb;
    CREATE USER wpuser@localhost IDENTIFIED BY 'password';
    GRANT ALL ON wpdb.* to wpuser@localhost;
    FLUSH PRIVILEGES;
    exit
    sudo cp wp-config-sample.php wp-config.php

Here, add credentials to `wp-config.php`.

    sudo chown -R www-data:www-data /var/www/html/
    sudo chmod -R 755 /var/www/html/
    sudo service apache2 stop
    sudo service apache2 start

Navigate to `[SERVER_IP]/wp-admin/install.php` and follow instructions. The
installation stage may take time.

#### Description

### [1] PHP Error Codes

### [2] Website Directory Structure

### [3] DDoS Through Low Bandwidth Connection

## Testing

### [1] PHP Error Codes

     ________ ________ ___________ __________ __________ _________ __________
    | Apache | PHP    | WordPress | Database | [1] Code | [2] Dir | [3] DDoS |
    |________|________|___________|__________|__________|_________|__________|
    | 2.4.18 | php7.0 | 4.6.1     | 14.14    | N        | N       | N        |
    |________|________|___________|__________|__________|_________|__________|

### [2] Website Directory Structure

### [3] DDoS Through Low Bandwidth Connection

## Results

## Conclusion
