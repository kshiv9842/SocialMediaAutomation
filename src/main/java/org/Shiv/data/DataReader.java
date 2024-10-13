package org.Shiv.data;

import static java.lang.System.getProperty;
import static java.lang.System.getenv;
import static java.util.Optional.ofNullable;

import java.nio.file.Path;

import org.Shiv.utils.JsonUtil;

public class DataReader {

    public static LandingProps readLandingProps () {
        LandingProps landingProps = null;
        if (landingProps == null) {
            final var defaultPath = Path.of (getProperty ("user.dir"), "src/main/resources/")
                .toString ();
            final var configDirectory = ofNullable (getenv ("LOGIN_PROPS_PATH")).orElse (
                ofNullable (getProperty ("login.props.path")).orElse (defaultPath));
            final var configPath = Path.of (configDirectory, "landing_props.json")
                .toString ();
            landingProps = JsonUtil.fromFile (configPath, LandingProps.class);
        }
        return landingProps;
    }
}