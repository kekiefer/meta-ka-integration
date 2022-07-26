LICENSE = "BSL-1.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e4224ccaecb14d942c71d31bef20d78c"

SRC_URI = "git://github.com/shibatch/sleef;protocol=https;branch=master \
           file://0001-Install-mkrename-for-native-build.patch \
           "

SRCREV = "cc4b0213f2f57a2f7e8f6355758dc40973ae9998"

S = "${WORKDIR}/git"

inherit cmake

DEPENDS += "mpfr openssl gmp coreutils-native"
DEPENDS:append:class-target = " ${PN}-native"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE:append:class-target = " -DNATIVE_BUILD_DIR=${STAGING_DIR_NATIVE}/usr"

EXTRA_OECMAKE = "-DBUILD_TESTS=OFF"

BBCLASSEXTEND = "native nativesdk"

