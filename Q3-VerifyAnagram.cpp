//
//  Q113-VerifyAnagram.cpp
//  Algorithm-Linux
//
//  Created by SanQ11iang Zhao on 12/3/12.
//  Copyright (c) 2012 SanQ11iang Zhao. All rights reserved.
//
/*
    std:cout<<isAnagram("sta", "tsa"); 
 */
#include "Q113-VerifyAnagram.h"

bool isAnagram(char *left, char *right)
{
    unsigned long length = strlen(left);
    if (length != strlen(right)) {
        return false;
    }
    int *checker = new int[0xff];
    while (*checker) {
        *checker=0;
    }
    
    while (*left) {
        ++checker[*left];
        ++left;
    }
    while (*right) {
        --checker[*right];
        if (checker[*right]<0) {
            return false;
        }
        ++right;
    }
    return true;
}