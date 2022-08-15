SUMMARY = "Image processing in Python"
HOMEPAGE = "https://scikit-image.org"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=850ce197dcedf0246c6db98622c1a2c9"

SRC_URI[sha256sum] = "24b5367de1762da6ee126dd8f30cc4e7efda474e0d7d70685433f0e3aa2ec450"

S = "${WORKDIR}/scikit-image-${PV}"

inherit setuptools3 pypi

DEPENDS += "python3-packaging-native python3-numpy-native python3-pythran-native"

#PACKAGECONFIG ?= "data optional test"
PACKAGECONFIG[data] = ",,,python3-pooch"
PACKAGECONFIG[optional] = ",,,python3-simpleitk python3-astropy python3-cloudpickle python3-dask[array]! python3-matplotlib python3-pooch python3-pyamg python3-qtpy"
PACKAGECONFIG[test] = ",,,python3-asv python3-codecov python3-flake8 python3-matplotlib python3-pooch python3-pytest python3-pytest-cov python3-pytest-faulthandler python3-pytest-localserver"

RDEPENDS:${PN} += "python3-pywavelets python3-imageio python3-networkx python3-numpy python3-packaging python3-pillow python3-scipy python3-tifffile"
