#!/usr/bin/env bash
#
# Copyright 2018-2021 Henri Tremblay.
#


java -cp app/target/classes:lib/target/classes app.App

#java --module-path app/target:lib/target -m java9.app/app.App

#java --module-path app/target:lib/target -m pro.tremblay.java9.app/app.App

#java --module-path app/target/classes:lib/target/classes -m pro.tremblay.java9.app/app.App

# --illegal-access=permit
# --add-opens pro.tremblay.java9.lib/lib=pro.tremblay.java9.app
# --add-opens java.base/java.lang=ALL-UNNAMED
# --add-opens java.base/java.lang=pro.tremblay.java9.app
