@objects
    body              xpath   //body

= WelcomePage =
    @on desktop
        body:
            image file imgs\desktop.png

    @on tablet
        body:
            image file imgs\tablet.png

    @on mobile
        body:
            image file imgs\mobile.png