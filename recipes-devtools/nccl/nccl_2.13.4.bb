LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=a443d82dbb2d29c3bc9ed8be7b9b2e5d"

SRC_URI = "git://github.com/NVIDIA/nccl;protocol=https;branch=master \
           file://0001-Support-passing-NVCUFLAGS-from-environment.patch \
           "

SRCREV = "19ab67d1727d337d10d0a48cbaf5cd119b8d88f1"

S = "${WORKDIR}/git"

inherit cuda

DEPENDS += "coreutils-native"

do_compile () {
	export CXX="${CXX_FOR_CUDA}"
	export NVCC="${CUDA_NVCC_EXECUTABLE}"
	export CUDA_HOME="${CUDA_TOOLKIT_ROOT}"
	export NVCC_GENCODE="${CUDA_NVCC_ARCH_FLAGS}"
	export NVCUFLAGS="${CUFLAGS}"
	oe_runmake src.build
}

do_install () {
        export PREFIX="${D}${prefix}"
	oe_runmake src.install
}

