LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=3b83ef96387f14655fc854ddc3c6bd57"

SRC_URI = "git://github.com/google/nsync.git;protocol=https;branch=master \
           file://0001-Export-cmake-config-file.patch \
           "

SRCREV = "436617053d0f39a1019a371c3a9aa599b3cb2cea"

S = "${WORKDIR}/git"

inherit cmake
