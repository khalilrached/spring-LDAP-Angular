# LEONI PROJECT
#

# 1. initialisation d'un serveur spring boot:

#

# 2. l'ajout d'un fichier .ldif

#

# 3. configuration de WebSecurity:
- ##  LDAP Authenthification
- ##  USER Authenthification + securing links
#

# 4. configuration de controller:
- les chemin
- /home: Method=GET
``` java
    @GetMaping("/home")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

```
- '/about': Method=GET
``` java
    @GetMaping("/about")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

```
- '/user': Method=GET
``` java
    @GetMaping("/user")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

```
- '/loginpage': Method=GET
``` java
    @GetMaping("/loginpage")
    public ModelAndView home(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("home");
        return mav;
    }

```
#
# 5. Thymeleaf configuration

#
# 6.  creation d'interface:
    html:
###        creation de 4 page .html
-   [about.html](https://github.com/khalilrached/spring-LDAP-Angular/blob/master/back-end/src/main/resources/templates/about.html)
-   [home.html](https://github.com/khalilrached/spring-LDAP-Angular/blob/master/back-end/src/main/resources/templates/home.html)
-   [loginpage.html](https://github.com/khalilrached/spring-LDAP-Angular/blob/master/back-end/src/main/resources/templates/loginpage.html)
-   [userdata.html](https://github.com/khalilrached/spring-LDAP-Angular/blob/master/back-end/src/main/resources/templates/user/userdata.html)
        
### avec l'utilisation de thymeleaf

``` html
    ...
    
    <html lang="en" xmlns:th="http://www.w3.org/1999/xhtml" >
    .
    .
    .
    <span th:if="${error}" class="error">wrong password or username !</span>
    
    ...
```

## - js:

*   creation d'un fichier .js

* -       main.js

## - css:

*  creation d'un fichier .css

* -        style.css
