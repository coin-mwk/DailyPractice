#!/usr/bin/env python
# -*- coding:utf-8 -*-
# @Time : 2020/11/23 10:06 上午
# @Author : Fitz
# @Description:  构建一个简单的图像识别算法，该算法可以将图片正确分类为猫和非猫


import inline as inline
import numpy as np
import matplotlib.pyplot as plt
import h5py
import scipy
from PIL import Image
from scipy import ndimage
from lr_utils import load_dataset

# %matplotlib inline



def main():
    # Loading the data (cat/non-cat)
    train_set_x_orig, train_set_y, test_set_x_orig, test_set_y, classes = load_dataset()

    # Example of a picture
    index = 5
    plt.imshow(train_set_x_orig[index])
    print("y = " + str(train_set_y[:, index]) + ", it's a '" + classes[np.squeeze(train_set_y[:, index])].decode(
        "utf-8") + "' picture.")


if __name__ == '__main__':
    main()
