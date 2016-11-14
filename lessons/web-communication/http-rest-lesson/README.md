---
title: HTTP and REST
duration: "1:35"
creator:
    name: Yuliya Kaleda
    city: NYC
---

# ![](https://ga-dash.s3.amazonaws.com/production/assets/logo-9f88ae6c9c3871690e33280fcf557f33.png) HTTP and REST


### LEARNING OBJECTIVES
*After this lesson, you will be able to:*
* Define HTTP and REST
* Examine an HTTP request/response and identify useful information
* Identify HTTP verbs and the uses for each
* Pass parameters into an HTTP request

### STUDENT PRE-WORK
*Before this lesson, you should already be able to:*
- Build and import an Android studio

### INSTRUCTOR PREP
*Before this lesson, instructors will need to:*
- Read through the lesson
- Add additional instructor notes as needed
- Edit language or examples to fit your ideas and teaching style
- Open, read, run, and edit (optional) the starter and solution code to ensure it's working and that you agree with how the code was written


### LESSON GUIDE

| TIMING  | TYPE  | TOPIC  |
|:-:|---|---|
| 10 min  | [Opening](#opening-10-mins)  | Discuss lesson objectives |
| 10 min  | [Introduction](#introduction-what-is-http-10-mins)  | What is HTTP? |
| 5 min  | [Demo](#demo-url-anatomy-5-mins)  | URL anatomy |
| 5 min  | [Guided Practice](#guided-practice-url-anatomy-5-mins)  | URL anatomy |
| 5 min  | [Introduction](#introduction-client-request-5-mins)  | Client request |
| 5 min  | [Demo](#demo-client-request-5-mins)  |  |
| 15 min  | [Introduction](#introduction-methods-15-mins)  | Methods |
| 10 min  | [Independent Practice](#independent-practice-client-request-10-mins)  | Client request |
| 5 min  | [Introduction](#introduction-server-response-5-mins)  | Server response |
| 10 min  | [Introduction](#introduction-response-code-10-mins)  | Response Code |
| 10 min  | [Independent Practice](#independent-practice-server-response-10-mins)  | Server response |

## Opening (10 mins)

Most apps do not exist in isolation. They get connected to cloud services, pull the data locally or are used just to browse in the web. It is important to understand what HTTP and REST are and how they work to make the most of them in your app.

Let's look at some vocabulary before we dig in:

- Cookie - a small piece of data sent from a website and stored in the user's web browser while the user is browsing it.

- Hypertext - structured text that uses logical links (hyperlinks) between nodes containing text. Example:


```html
<html>
	<body>
		<a href=“http://www.ga.nyc”/> 	
	</body>
</html>
```

- URL - a reference (an address) to a resource on the Internet. A URL has two main components:
* protocol identifier: For the URL http://example.com, the protocol identifier is http
* resource name: For the URL http://example.com , the resource name is example.com

## Introduction: What is HTTP? (10 mins)

##### HTTP
Hypertext Transfer Protocol: an application protocol for distributed, collaborative, hypermedia information systems. It is the foundation of data communication for the World Wide Web. HTTP is the protocol to exchange or transfer hypertext. HTTP is a stateless protocol. A stateless protocol does not require the HTTP server to retain information or status about each user for the duration of multiple requests.

In HTTP, there are two different roles: server and client. In general, the client always initiates the conversation; the server replies.

##### REST

REST stands for Representational State Transfer. (It is sometimes spelled "ReST".) It relies on a stateless, client-server, cacheable communications protocol -- and in virtually all cases, the HTTP protocol is used. REST is an architecture style for designing networked applications. The idea is that, rather than using complex mechanisms such as CORBA, RPC or SOAP to connect between machines, simple HTTP is used to make calls between machines.

##### How simple is REST?

Using Web Services and SOAP, the request would look something like this:

```xml
<?xml version="1.0"?>
<soap:Envelope
xmlns:soap="http://www.w3.org/2001/12/soap-envelope"
soap:encodingStyle="http://www.w3.org/2001/12/soap-encoding">
 <soap:body pb="http://www.acme.com/phonebook">
  <pb:GetUserDetails>
   <pb:UserID>12345</pb:UserID>
  </pb:GetUserDetails>
 </soap:Body>
</soap:Envelope>
```

With REST the query URL will probably look like this:

```
http://www.acme.com/phonebook/UserDetails/12345
```

It is a simple URL with a single parameter. REST can easily handle more complex requests, including multiple parameters.


## Demo: URL anatomy (5 mins)

Let's break a URL into parts ```http://www.example.co.in:80/example.php?x=1&y=2#results```:

* The **protocol** is http
* The **domain** is www.example.co.in
* The **port** is 80
* The **path** is /example.php
* The **query** string is ?x=1&y=2#results. This query string can be further divided into parameter. URLs can have lots parameters. Parameters start with a question mark (?) and are separated with an ampersand (&). First parameter is x with value 1.
* The **hash** is #results

## Guided Practice: URL anatomy (5 mins)
Look at the url and break it into separate parts. Name each of them:
```
http://www.acme.com/phonebook/UserDetails?firstName=John&lastName=Doe
```


## Introduction: Client request (5 mins)
HTTP messages are made of a **header** and a **body**. The body can often remain empty; it contains data that you want to transmit over the network, in order to use it according to the instructions in the header. The header contains metadata, such as encoding information; but, in the case of a request, it also contains the important HTTP methods. Now let's look at the client request.

## Demo: Client request (5 mins):

```
GET /index.html HTTP/1.1        request line
Host: www.example.com           request header
Header1: value1
Header2: value2
...
                                blank line
w2hjh2jhje                      message body                               
```  
As you can see in the request line:
* GET - a method
* /index.html - request URI
* HTTP/1.1 - version


## Introduction: Methods (15 mins)

Each request specifies a certain HTTP verb, or method, in the request header. This is the first all caps word in the request header. HTTP verbs tell the server what to do with the data identified by the URL:

**GET**: requests a representation of the specified resource. Requests using GET should only retrieve data and should have no other effect.

**POST**: requests that the server accept the entity enclosed in the request as a new subordinate of the web resource identified by the URI.

**HEAD**: requests a response identical to that of a GET request, but without the response body. Useful for retrieving info like response headers, without having to transport the entire content.

**PUT**: requests that the enclosed entity be stored under the supplied URI.

* If the URI refers to an already existing resource, it is modified

* if the URI does not point to an existing resource, then the server can create the resource with that URI.

**DELETE**: deletes the specified resource.

**OPTIONS**: returns the HTTP methods that the server supports for the specified URL.

##### Safe Methods
HEAD, GET, OPTIONS are, by convention, defined as safe, which means they are intended only for information retrieval and should not change the state of the server. In other words, they should not have side effects, beyond relatively harmless effects such as logging, caching, the serving of banner
advertisements or incrementing a web counter. Making arbitrary GET requests without regard to the context of the application's state should therefore be considered safe.

POST, PUT, DELETE and PATCH are intended for actions that may cause side effects either on the server, or external side effects such as
financial transactions or transmission of email.

##### Idempotent Methods

These methods achieve the same result, no matter how many times the request is repeated. GET, PUT, PATCH, HEAD, OPTIONS and DELETE are considered idempotent. In contrast, the POST method is not necessarily idempotent. Sending an identical POST request multiple times may further affect
state or cause further side effects (such as financial transactions).

##### Headers

The headers can contain the following information:

* User-Agent: A string identifying the user agent. For instance:

```
User-Agent: Mozilla/5.0 (X11; Linux x86_64; rv:12.0) Gecko/20100101 Firefox/21.0
```
* Host (the mandatory element). For instance:  

```
Host: en.wikipedia.org
```

* Content-Type: The MIME type of the body of the request (used with POST and PUT requests). For instance:

```
Content-Type: application/json
```

* Content-Length: The length of the request body in bytes. For instance:

```
Content-Length: 348
```

* Referer: This is the address of the previous web page from which a link to the currently requested page was followed. For instance:

```
Referer: http://en.wikipedia.org/wiki/Main_Page
```

* If-Modified-Since: Allows the server not to return a page again if content is unchanged. For instance:

```
If-Modified-Since: Sat, 29 Oct 1994 19:43:31 GMT
```


## Independent Practice: Client request (10 mins)

In pairs look at the client request and break it into the parts we just reviewed.

```
POST /path/script.cgi HTTP/1.0
From: frog@jmarshall.com
User-Agent: HTTPTool/1.0
Content-Type: application/x-www-form-urlencoded
Content-Length: 32

home=Cosby&favorite+flavor=flies
```

## Introduction: Server response (5 mins)

After receiving and interpreting a request message, a server responds with an HTTP response message. Its main parts are status line, response header and body.


```
HTTP/1.1 200 OK                               status line
Date: Mon, 23 May 2005 22:38:34 GMT           response header
more headers...
<html>                                        response body
	<head>
	 	<title>An Example Page</title>
	</head>
	<body>
 		Hello World, this is a very simple HTML document.
	</body>
</html>
```

## Introduction: Response Code (10 mins)


Response Code element is a 3-digit integer result code of the attempt to understand and satisfy the request. The first digit of the Status-Code defines the class of response. The last two digits do not have any categorization role. There are 5 values for the first digit:

- 1xx: Informational - Request received, continuing process
- 2xx: Success - The action was successfully received, understood, and accepted
- 3xx: Redirection - Further action must be taken in order to complete the request
- 4xx: Client Error - The request contains bad syntax or cannot be fulfilled
- 5xx: Server Error - The server failed to fulfill an apparently valid request

##### Examples:

- 200 OK (Standard response for successful HTTP requests)  
- 201 Created (The request has been fulfilled and resulted in a new resource being created)  
- 301 Moved Permanently (This and all future requests should be directed to the given URI)  
- 400 Bad Request (The server cannot process the request due to something that is perceived to be a client error)  
- 403 Forbidden (The request was a valid request, but the server is refusing to respond to it. Unlike a 401 Unauthorized response, authenticating will make no difference)   
- 401 Unauthorized (Similar to 403 Forbidden, but specifically for use when authentication is required and has failed or has not yet been provided)  
- 500 Internal Server Error (A generic error message, given when an unexpected condition was encountered and no more specific message is suitable)  


##### Headers

* Server: A name for the server. For instance:  

```

```Server: Apache/2.4.1 (Unix)```
* Content-Length
* Content-Type
* Content-Disposition: An opportunity to raise a "File Download" dialogue box for a known MIME type with binary format or suggest a filename for dynamic content. Quotes are necessary with special characters. For instance:  
```Content-Disposition: attachment; filename="fname.ext"```
* Expires: Gives the date/time after which the response is considered stale. For instance:  
```Expires: Thu, 01 Dec 1994 16:00:00 GMT```
* Last-Modified: The last modified date for the requested object. For instance:  	
```Last-Modified: Tue, 15 Nov 1994 12:45:26 GMT```
* Retry-After: If an entity is temporarily unavailable, this instructs the client to try again later. Value could be a specified period of time (in seconds) or a date. For instance:  
```Retry-After: 120```  
```Retry-After: Fri, 07 Nov 2014 23:59:59 GMT```  
* Location: Used in redirection, or when a new resource has been created. For instance:  
```Location: http://www.w3.org/pub/WWW/People.html```  
* Allow: Valid methods for a specified resource:  
```Allow: GET, HEAD```
* Set-Cookie: An HTTP cookie:  
```Set-Cookie: UserID=JohnDoe; Max-Age=3600; Version=1```
* Cache-Control: Tells all caching mechanisms from server to client whether they may cache this object. It is measured in seconds:  
```Cache-Control: max-age=3600```
* Pragma: Implementation-specific fields that may have various effects anywhere along the request-response chain:  
```Pragma: no-cache```

```

## Independent Practice: Server response (10 mins)

In pairs look at the response and break it into parts:

```
HTTP/1.1 200 OK
Date: Mon, 27 Jul 2009 12:28:53 GMT
Server: Apache/2.2.14 (Win32)
Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT
Content-Length: 88
Content-Type: text/html
Connection: Closed
<html>
	<body>
		<h1>Hello, World!</h1>
	</body>
</html>
```


# Conclusion (5 mins)

When we talk about HTTP and REST, we mean different things. It is very important to understand the difference between them. HTTP stands for HyperText Transfer Protocol and is a way to transfer files. This protocol is used to link pages of hypertext in what we call the world-wide-web. However, there are other transfer protocols available, like FTP and gopher, yet they are less popular.

REpresentational State Transfer, or REST, is a set of constraints that ensure a scalable, fault-tolerant and easily extendible system. The world-wide-web is an example of such system (and the biggest example, one might say). REST by itself is not a new invention, but it's the documentation on such systems like the world-wide-web.

One thing that confuses people, is that REST and HTTP seem to be hand-in-hand. After all, the world-wide-web itself runs on HTTP, and it makes sense, a RESTful API does the same. However, there is nothing in the REST constraints that makes the usage of HTTP as a transfer protocol mandatory. It's perfectly possible to use other transfer protocols like SNMP, SMTP and others to use, and your API could still very well be a RESTful API.

- What does HTTP stand for?
- What parts does a client request have?
- What parts can a server response have?
- What are the request methods?
- What methods are Idempotent?
