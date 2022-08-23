inherit cuda

def torch_cuda_archs(d):
    archs = d.getVar('CUDA_ARCHITECTURES')
    if not archs:
        return ""
    return " ".join([f"{arch[:-1]}.{arch[-1]}" for arch in archs.split()])

TORCH_CUDA_ARCH_LIST:cuda ?= "${@torch_cuda_archs(d)}"
TORCH_DONT_CHECK_COMPILER_ABI = "1"

EXTRA_OECMAKE:append:cuda = " \
    -DTORCH_CUDA_ARCH_LIST='${TORCH_CUDA_ARCH_LIST}' \
    -DCMAKE_CUDA_COMPILER_FORCED=1 \
    -DTORCH_DONT_CHECK_COMPILER_ABI=${TORCH_DONT_CHECK_COMPILER_ABI} \
"

CUDA_HOME:cuda ?= "${CUDA_TOOLKIT_ROOT}"

export TORCH_CUDA_ARCH_LIST
export TORCH_DONT_CHECK_COMPILER_ABI
export CUDA_HOME
