cmake_minimum_required(VERSION 3.9)
project(clion_proj C)

set(CMAKE_C_STANDARD 11)

add_executable(clion_proj main.c ciphers.c ciphers.h)