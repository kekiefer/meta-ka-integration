LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://github.com/google/flatbuffers.git;protocol=https;branch=master"

SRCREV = "6df40a2471737b27271bdd9b900ab5f3aec746c7"

PACKAGE_BEFORE_PN = "${PN}-compiler"

DEPENDS = "flatbuffers1-native"

RDEPENDS:${PN}-compiler = "${PN}"
RDEPENDS:${PN}-dev += "${PN}-compiler"

S = "${WORKDIR}/git"

CVE_CHECK_IGNORE += "CVE-2020-35864"

EXTRA_OECMAKE += " \
    -DFLATBUFFERS_BUILD_TESTS=OFF \    
    -DFLATBUFFERS_BUILD_SHAREDLIB=ON \
"

EXTRA_OECMAKE:append:class-target = " \
    -DFLATBUFFERS_FLATC_EXECUTABLE=${STAGING_BINDIR_NATIVE}/flatc \
    -DFLATBUFFERS_BUILD_FLATC=OFF \
"

inherit cmake python3native

FILES:${PN}-compiler = "${bindir}"

BBCLASSEXTEND = "native nativesdk"
