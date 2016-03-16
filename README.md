# Fake Mail Server [![Build Status](https://travis-ci.org/jibhaine/fake-mail-server.svg)](https://travis-ci.org/jibhaine/fake-mail-server)

A fake smtp server embedded in a war webapp.

## Why ?

I was growing tired of the application i'm currently working on sending exceptions because of no SMTP server available for local development/debug.

So i created a simple wrapper around SubEthaSMTP, embedded in a war file.

It has since grow in a webapp for displaying received mails.

## What ?

## How ?

Just deploy the fms.war file in your favourite application server and it should work.


## TODO

* Use The mail template from PureCSS : http://purecss.io/layouts/email/
* Use websockets to refresh mail list.
* Update unread mails in favicon and page title.

