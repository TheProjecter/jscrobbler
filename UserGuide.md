# User Guide #
## Introduction ##
jScrobbler is a project built with Maven 1, here you will find the steps that you need to get the project running in Eclipse.

## Requirements ##
At least [Java 5](http://java.sun.com/javase/downloads/index.jsp), a Subversion client such as  [TortoiseSVN](http://tortoisesvn.tigris.org/) or if you use Eclipse  [Subclipse](http://subclipse.tigris.org/) is a good choice and [Maven 1.0](http://maven.apache.org/maven-1.x/).

I will not give information about installing or configuring these tools. Please take a look at the documentation from the respective sites.

## Steps ##

1) Checkout the project from the subversion repository with the following command:
> `svn checkout http://jscrobbler.googlecode.com/svn/trunk/jscrobbler`
2) Go to the location where you placed the project
3) Execute the following maven command from the command prompt:
> ` maven eclipse`
This command will create .project and .classpath files for eclipse.

4) Open Eclipse

5) Import an existing project into workspace

![http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import.png](http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import.png)

6) Locate the project, select it and click finish:

![http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import2.png](http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import2.png)

7) Eclipse should look like the following image:

![http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import3.png](http://jscrobbler.googlecode.com/svn/trunk/jscrobbler/jScrobbler/site/img/eclipse-import3.png)






















