SUMMARY = "A date and time library based on C++11/14/17."
AUTHOR = "Howard Hinnant"
HOMEPAGE = "https://github.com/HowardHinnant/date.git"
SECTION = "libs"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=b5d973344b3c7bbf7535f0e6e002d017"

SRC_URI = " \
	git://github.com/HowardHinnant/date.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"
SRCREV = "5bdb7e6f31fac909c090a46dbd9fea27b6e609a4"

inherit cmake

EXTRA_OECMAKE += " \
	-DENABLE_DATE_TESTING=OFF \
	-DUSE_SYSTEM_TZ_DB=ON \
"
