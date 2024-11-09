module Mini.Paint {
    requires javafx.controls;
    requires javafx.media;

    opens frontend;
    exports frontend;
    exports backend;
}