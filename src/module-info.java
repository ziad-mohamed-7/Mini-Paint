module Mini.Paint {
    requires javafx.controls;
    requires javafx.media;
    requires java.desktop;

    opens frontend;
    exports frontend;
    exports backend;
}