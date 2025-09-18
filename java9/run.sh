#!/usr/bin/env bash
#
# Copyright 2018-2022 Henri Tremblay.
#


java -cp app/target/classes:api/target/classes:lib/target/classes app.App

#java --module-path app/target:api/target:lib/target -m java9.app/app.App

#java --module-path app/target:api/target:lib/target -m pro.tremblay.java9.app/app.App

#java --module-path app/target/classes:api/target/classes:lib/target/classes -m pro.tremblay.java9.app/app.App

# --illegal-access=permit deny warn
# --add-opens pro.tremblay.java9.lib/lib=pro.tremblay.java9.app
# --add-opens java.base/java.lang=ALL-UNNAMED
# --add-opens java.base/java.lang=pro.tremblay.java9.app
