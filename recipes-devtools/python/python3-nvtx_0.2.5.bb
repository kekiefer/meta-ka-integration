# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=0bcd48c3bdfef0c9d9fd17726e4b7dab"

SRC_URI = "git://github.com/NVIDIA/NVTX;protocol=https;branch=dev \
           file://0001-Fix-python-paths-for-cross-build.patch \
           "
SRCREV = "3c73121518c12d896200960e63b663e12aa52acb"

S = "${WORKDIR}/git"

inherit setuptools3 cuda

DEPENDS += " \
    cuda-nvtx \
    python3-cython-native \
"

RDEPENDS:${PN} += " \
    python3-core \
    cuda-nvtx \
"

SETUPTOOLS_SETUP_PATH = "${S}/python"
CFLAGS:append = " -I${S}/c/include"
