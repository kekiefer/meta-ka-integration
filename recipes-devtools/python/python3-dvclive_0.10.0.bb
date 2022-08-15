SUMMARY = "Metric logger for ML projects."
HOMEPAGE = "https://dvc.org/doc/dvclive"
LICENSE = "Apache-2.0"
LIC_FILES_CHKSUM = "file://LICENSE;md5=fef38889a03a02fb440e1dacbaad4021"

SRC_URI[sha256sum] = "0a56c76619ba194de5239f0857b6c0a4cb596f6d829bcc2128887c00b429ab1b"

S = "${WORKDIR}/dvclive-${PV}"

inherit setuptools3 pypi

#PACKAGECONFIG ?= "all catalyst fastai huggingface image lgbm mmcv plots pytorch-lightning sklearn tests tf xgb"
PACKAGECONFIG[all] = ",,,python3-catalyst python3-datasets python3-fastai python3-lightgbm python3-mmcv python3-pillow python3-pytorch_lightning python3-scikit-learn python3-tensorflow python3-transformers python3-xgboost"
PACKAGECONFIG[catalyst] = ",,,python3-catalyst"
PACKAGECONFIG[fastai] = ",,,python3-fastai"
PACKAGECONFIG[huggingface] = ",,,python3-datasets python3-transformers"
PACKAGECONFIG[image] = ",,,python3-pillow"
PACKAGECONFIG[lgbm] = ",,,python3-lightgbm"
PACKAGECONFIG[mmcv] = ",,,python3-mmcv"
PACKAGECONFIG[plots] = ",,,python3-scikit-learn"
PACKAGECONFIG[pytorch_lightning] = ",,,python3-pytorch-lightning"
PACKAGECONFIG[sklearn] = ",,,python3-scikit-learn"
PACKAGECONFIG[tests] = ",,,python3-catalyst python3-datasets python3-dvc python3-fastai python3-funcy python3-lightgbm python3-mmcv python3-pandas python3-pillow python3-pre-commit python3-pylint python3-pylint-plugin-utils python3-pytest python3-pytest-cov python3-pytest-mock python3-pytorch_lightning python3-scikit-learn python3-tensorflow python3-transformers python3-xgboost"
PACKAGECONFIG[tf] = ",,,python3-tensorflow"
PACKAGECONFIG[xgb] = ",,,python3-xgboost"

RDEPENDS:${PN} += "python3-dvc-render"
