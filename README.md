# Quill embedded insert bug repro

#Expected
 
[These lines](https://github.com/lloydmeta/quill-insert-embedded/blob/master/src/main/scala/com/example/Main.scala#L21-L25) should work just the same as [these lines](https://github.com/lloydmeta/quill-insert-embedded/blob/master/src/main/scala/com/example/Main.scala#L27-L32). 

Actual: 

Uncommenting out the former results in 

```scala
[error] scala.reflect.macros.TypecheckException: exception during macro expansion: 
[error] java.lang.NullPointerException
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:44)
[error]         at io.getquill.ast.StatefulTransformer$class.apply(StatefulTransformer.scala:137)
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:25)
[error]         at io.getquill.ast.StatefulTransformer$$anonfun$5$$anonfun$apply$5.apply(StatefulTransformer.scala:169)
[error]         at io.getquill.ast.StatefulTransformer$$anonfun$5$$anonfun$apply$5.apply(StatefulTransformer.scala:169)
[error]         at io.getquill.ast.StatefulTransformer$$anonfun$apply$7.apply(StatefulTransformer.scala:191)
[error]         at io.getquill.ast.StatefulTransformer$$anonfun$apply$7.apply(StatefulTransformer.scala:189)
[error]         at scala.collection.LinearSeqOptimized$class.foldLeft(LinearSeqOptimized.scala:124)
[error]         at scala.collection.immutable.List.foldLeft(List.scala:84)
[error]         at io.getquill.ast.StatefulTransformer$class.apply(StatefulTransformer.scala:189)
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:25)
[error]         at io.getquill.ast.StatefulTransformer$class.apply(StatefulTransformer.scala:169)
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:25)
[error]         at io.getquill.ast.StatefulTransformer$class.apply(StatefulTransformer.scala:11)
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:74)
[error]         at io.getquill.quotation.ReifyLiftings$ReifyLiftings.apply(ReifyLiftings.scala:72)
[error]         at io.getquill.quotation.ReifyLiftings$class.reifyLiftings(ReifyLiftings.scala:79)
[error]         at io.getquill.dsl.QuotationMacro.reifyLiftings(QuotationDsl.scala:37)
[error]         at io.getquill.quotation.Quotation$class.quote(Quotation.scala:24)
[error]         at io.getquill.dsl.QuotationMacro.quote(QuotationDsl.scala:37)
[error] 
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$typecheck$2$$anonfun$apply$1.apply(Typers.scala:34)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$typecheck$2$$anonfun$apply$1.apply(Typers.scala:28)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$3.apply(Typers.scala:24)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$3.apply(Typers.scala:24)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$withContext$1$1.apply(Typers.scala:25)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$withContext$1$1.apply(Typers.scala:25)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$1.apply(Typers.scala:23)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$1.apply(Typers.scala:23)
[error]         at scala.reflect.macros.contexts.Typers$class.withContext$1(Typers.scala:25)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$typecheck$2.apply(Typers.scala:28)
[error]         at scala.reflect.macros.contexts.Typers$$anonfun$typecheck$2.apply(Typers.scala:28)
[error]         at scala.reflect.internal.Trees$class.wrappingIntoTerm(Trees.scala:1716)
[error]         at scala.reflect.internal.SymbolTable.wrappingIntoTerm(SymbolTable.scala:16)
[error]         at scala.reflect.macros.contexts.Typers$class.withWrapping$1(Typers.scala:26)
[error]         at scala.reflect.macros.contexts.Typers$class.typecheck(Typers.scala:28)
[error]         at scala.reflect.macros.contexts.Context.typecheck(Context.scala:6)
[error]         at scala.reflect.macros.contexts.Context.typecheck(Context.scala:6)
[error]         at io.getquill.context.ContextMacro$class.extractAst(ContextMacro.scala:35)
[error]         at io.getquill.context.ActionMacro.extractAst(ActionMacro.scala:10)
[error]         at io.getquill.context.ActionMacro.runAction(ActionMacro.scala:19)
[error]   ctx.run(q)
[error]          ^
```