SUMMARY = "image and video datasets and models for torch deep learning"
HOMEPAGE = "https://github.com/pytorch/vision"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd7749a3307486a4d4bfefbc81c8b796"

SRC_URI = "git://github.com/pytorch/vision;protocol=https;branch=release/0.13 \
           file://0001-Don-t-set-RPATH-during-installation.patch \
           file://0002-Fix-splitting-NVCC-flags.patch \
           file://0003-Fix-location-of-libpng.patch \
           "
SRCREV = "bddbd7e6d65ecacc2e40cf6c9e2059669b8dbd44"

S = "${WORKDIR}/git"

inherit cmake setuptools3
require torch-cuda.inc

DEPENDS += " \
    ninja-native \
    python3-torch-native \
    python3-torch \
"

PACKAGECONFIG ?= "scipy png jpg"

PACKAGECONFIG[jpg] = ",,jpeg"
PACKAGECONFIG[png] = ",,libpng"
PACKAGECONFIG[scipy] = ",,,python3-scipy"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"

RDEPENDS:${PN} += "python3-torch python3-numpy"

export TORCH_INSTALL_PREFIX = "${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/torch"
export TORCHVISION_INCLUDE = "${STAGING_INCDIR}"
export TORCHVISION_LIBRARY = "${STAGING_LIBDIR}"
export BUILD_DIR = "${B}"
export FORCE_CUDA = "1"
export NVCC_FLAGS = "${CUFLAGS}"

# look in target sysroot site-packages directory for libraries
LDFLAGS:append = " -L${STAGING_DIR_TARGET}${PYTHON_SITEPACKAGES_DIR}/torch/lib"

do_configure() {
    cmake_do_configure
}

do_compile() {
    export LD_LIBRARY_PATH="$LD_LIBRARY_PATH:${STAGING_DIR_NATIVE}${PYTHON_SITEPACKAGES_DIR}/torch/lib"
    cmake_do_compile
    setuptools3_do_compile
}

do_install() {
    setuptools3_do_install
    cmake_do_install
}

SOLIBS = ".so"
FILES_SOLIBSDEV = ""
