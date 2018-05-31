@objects
    modal              xpath   //*[@id='modal-properties']

= WelcomePage =
    @on desktop
        modal:
            image file imgs\desktop.png

    @on tablet
        modal:
            image file imgs\tablet.png

    @on mobile
        modal:
            image file imgs\mobile.png