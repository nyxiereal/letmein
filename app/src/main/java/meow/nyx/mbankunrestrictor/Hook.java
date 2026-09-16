package meow.nyx.mbankunrestrictor;

import static de.robv.android.xposed.XC_MethodReplacement.DO_NOTHING;
import static de.robv.android.xposed.XC_MethodReplacement.returnConstant;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public final class Hook implements IXposedHookLoadPackage {
    private static final String TARGET = "pl.mbank";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam app) {
        if (!TARGET.equals(app.packageName)) return;

        try {
            findAndHookMethod("pl.mbank.mcore.pr2.f", app.classLoader, "e0", returnConstant(true));
            findAndHookMethod("pl.mbank.mcore.jk0.p", app.classLoader, "b", returnConstant(false));
            findAndHookMethod(
                    "pl.mbank.mcore.vf3.qk", app.classLoader, "b", String.class, DO_NOTHING);
            findAndHookMethod(
                    "pl.mbank.mcore.vf3.dm", app.classLoader, "b", returnConstant(null));
            findAndHookMethod(
                    "pl.mbank.mcore.ck0.t",
                    app.classLoader,
                    "a",
                    findClass("pl.mbank.mcore.xc3.a", app.classLoader),
                    DO_NOTHING);
            XposedBridge.log("mBank Unrestrictor: hooks active");
        } catch (Throwable error) {
            XposedBridge.log("mBank Unrestrictor: " + error);
        }
    }
}
