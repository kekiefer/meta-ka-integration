FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://0001-Install-mp11-as-standalone-cmake-project.patch"

BOOST_LIBS:append = " mp11"
