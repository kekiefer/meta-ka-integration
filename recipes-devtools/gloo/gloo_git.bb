# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
#   gloo/transport/uv/LICENSE.uvw
LICENSE = "Unknown"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ea1ecec5f757696cea349b925fa70342 \
                    file://gloo/transport/uv/LICENSE.uvw;md5=75598a838148e597d8f0e810a57f3855"

SRC_URI = "gitsm://github.com/facebookincubator/gloo;protocol=https;branch=main \
           file://0001-Support-cross-build.patch \
           "

# Modify these as desired
PV = "1.0+git${SRCPV}"
SRCREV = "950c0e23819779a9e0c70b861db4c52b31d1d1b2"

S = "${WORKDIR}/git"

inherit cmake pkgconfig cuda

DEPENDS += "openssl nccl hiredis"

# Specify any options you want to pass to cmake using EXTRA_OECMAKE:
EXTRA_OECMAKE += " \
    -DUSE_CUDA=1 \
    -DCUDA_SDK_ROOT_DIR=${CUDA_TOOLKIT_ROOT} \
    -DCUDA_VERBOSE_BUILD=1 \
"

