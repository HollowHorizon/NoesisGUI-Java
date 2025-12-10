package dev.sixik.noesisgui.nscore;

/**
 * Represents an object that participates in the dependency property system.
 * <p>
 * The DependencyObject class enables the property system services on its many derived classes.
 * The property system's primary function is to compute the values of properties, and to provide
 * system notification about values that have changed. Another key class that participates in the
 * property system is DependencyProperty. DependencyProperty enables the registration of
 * dependency properties into the property system, and provides identification and information
 * about each dependency property, whereas DependencyObject as a base class enables objects to use
 * the dependency properties.
 *
 * @see <a href="http://msdn.microsoft.com/en-us/library/system.windows.dependencyobject.aspx">
 *      Microsoft Documentation: DependencyObject Class</a>
 */
public class NSDependencyObject extends NSDispatcherObject {

    public NSDependencyObject(long ptr) {
        super(ptr);
    }


    @Deprecated
    private static native long nativeCreate();

    @Deprecated
    private static native long nativeGetValueObject(long ptr, long dependencyPropertyPtr);

    @Deprecated
    private static native long nativeGetLocalValue(long ptr, long dependencyPropertyPtr);
}
