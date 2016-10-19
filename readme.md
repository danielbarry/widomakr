# WidoMakr

    ||    ||
     \\()//
    //(__)\\
    ||    ||

"*What wicked webs we weave.*"

WidoMakr is web discovery tool written in Java, a collection of tools for
quickly determining what information can be discovered and where potential
exploits may exist.

The tool has been designed to be operated via the terminal so that it may be
used easily with other tools to create powerful testing arsenals.

## Pre-Requisites

For installation, you will require:

  * Ant (Java build system)
  * Git (Repository tool)
  * Java (JRE - Java runtime environment)
  * Javac (JDK - Java compiler)

### Linux

    sudo apt-get update
    sudo apt-get install ant git openjdk-8-jre openjdk-8-jdk

## Installation

In a directory (such as `widomakr`) you wish to install this program, run:

    git clone git@github.com:danielbarry/widomakr.git

For the first run, please run:

    ant

Assuming the build is successful, you should now be able to run the program.

## Updating/Upgrading

This program uses Git to update itself which requires pulling in all of the
changes from the remote repository and recompiling. To do this, simply use:

    widomakr update
    widomakr upgrade

## Bugs

We track bugs using the GitHub
[issues](https://github.com/danielbarry/widomakr/issues) tracking system.
