# Log explorer 🔍

A training project for Scala.

We consider a `.txt` file with the following format : 
```
<unix epoch time> <source hostname> <target hostname>
```

Example :

```
1550701578 host6 host4
1550699325 host3 host6
1550699903 host9 host4
1550698698 host9 host5
1550700181 host3 host1
``` 

This file traces the connection between two hosts at a given time.

The goal of our program is to produce the following information on every hour :
* the list of the connections during the last hour
* the server that generated the most important number of connections during the last hour
* the most recent connection between two servers  