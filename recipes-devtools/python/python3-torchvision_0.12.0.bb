SUMMARY = "image and video datasets and models for torch deep learning"
HOMEPAGE = "https://github.com/pytorch/vision"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=bd7749a3307486a4d4bfefbc81c8b796"

SRC_URI = "git://github.com/pytorch/vision;protocol=https;branch=release/0.11 \
           file://0001-Add-support-for-Yocto.patch \
           "
SRCREV = "05eae32f9663bbecad10a8d367ccbec50130e2f5"

S = "${WORKDIR}/git"

inherit setuptools3

PACKAGECONFIG ?= "scipy png jpg"

PACKAGECONFIG[jpg] = ",,jpeg"
PACKAGECONFIG[png] = ",,libpng"
PACKAGECONFIG[scipy] = ",,,python3-scipy"
PACKAGECONFIG[ffmpeg] = ",,ffmpeg"

DEPENDS += " \
    protobuf-native \
    python3-numpy \
    python3-pillow \
    python3-torch \
"

RDEPENDS:${PN} += "python3-compression python3-core python3-crypt python3-ctypes python3-html python3-io python3-json python3-math python3-multiprocessing python3-numbers python3-numpy python3-pickle python3-pillow python3-requests python3-shell python3-stringold python3-xml"

CFLAGS += "-I${STAGING_INCDIR}/torch/csrc/api/include"