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
SRCREV = "e7e1482087f58913b80a20b04d5c58d9d6d90155"

inherit cmake

EXTRA_OECMAKE += " \
	-DENABLE_DATE_TESTING=OFF \
	-DUSE_SYSTEM_TZ_DB=ON \
"
