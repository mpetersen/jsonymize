# jsonymize - Anonymize JSON

This is a small script to anonymize and pretty print JSON files.

## Build and installation

The Java application has to be built using:

    mvn clean install

or

    make build

Then install the script into the `PATH`, e.g.:

    make install

> **Warning**
> 
> This command will create a new link in `/usr/local/bin`. If the link exists before, it will be overwritten.

In short, to build and install in one line:

    make build install

or just simply:

    make


## Uninstall

To remove the link from `/usr/local/bin`, run the following command:

    make uninstall


## Usage

To run the Java application from command line, use the following script:

    jsonymize <filename>


## Features

Anonymizes all values of the JSON file while keeping the data types.
Automatically detects UUIDs and IP addresses.

Does not anonymize boolean values.
