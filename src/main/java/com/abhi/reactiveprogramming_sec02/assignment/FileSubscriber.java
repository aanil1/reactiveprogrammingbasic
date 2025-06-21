package com.abhi.reactiveprogramming_sec02.assignment;

import com.abhi.common.Util;
import com.abhi.reactiveprogramming_sec02.assignment.FileServiceImpl;

public class FileSubscriber {

    public static void main(String[] args)
    {
        var fileService = new FileServiceImpl();
        fileService.writeFile("file.txt", "Hello World")
                .subscribe(Util.subscribe("file write subscriber"));

        fileService.getFile("file.txt")
                .subscribe(Util.subscribe("file read subscriber"));
        fileService.deleteFile("file.txt")
                .subscribe(Util.subscribe("file delete subscriber"));

    }

}
