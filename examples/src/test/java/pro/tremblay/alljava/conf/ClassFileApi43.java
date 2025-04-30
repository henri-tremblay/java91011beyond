/*
 * Copyright 2018-2025 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import java.io.PrintStream;
import java.lang.classfile.ClassFile;
import java.lang.constant.ClassDesc;
import java.lang.constant.MethodTypeDesc;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.lang.classfile.ClassFile.ACC_PRIVATE;
import static java.lang.classfile.ClassFile.ACC_PUBLIC;
import static java.lang.classfile.ClassFile.ACC_STATIC;
import static java.lang.constant.ConstantDescs.CD_String;
import static java.lang.constant.ConstantDescs.CD_void;
import static java.lang.constant.ConstantDescs.INIT_NAME;

public class ClassFileApi43 {

  public static final ClassDesc PRINT_STREAM = ClassDesc.of(PrintStream.class.getName());

  void main() throws Exception {
    Files.write(Path.of("MyClass.class"), buildClass());
  }

  public static byte[] buildClass() {
    return ClassFile.of().build(ClassDesc.of("MyClass"), cb -> cb
      // Generate default constructor
      .withMethod(INIT_NAME, MethodTypeDesc.of(CD_void),
        ACC_PRIVATE, mb -> mb.withCode(codec -> codec
          .aload(0)
          .invokespecial(ClassDesc.of(Object.class.getName()), INIT_NAME, MethodTypeDesc.of(CD_void))
          .return_()))

      // Generate main method
      .withMethod("main",
        MethodTypeDesc.of(CD_void, ClassDesc.of(String.class.getName()).arrayType()),
        ACC_PUBLIC | ACC_STATIC,
        mb -> mb.withCode(codec -> codec
          .getstatic(ClassDesc.of(System.class.getName()), "out", PRINT_STREAM)
          .ldc("Bonjour")
          .invokevirtual(PRINT_STREAM, "println", MethodTypeDesc.of(CD_void, CD_String))
          .return_()))
    );
  }
}

// java MyClass
