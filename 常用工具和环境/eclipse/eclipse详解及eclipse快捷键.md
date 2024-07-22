eclipse在我们开发中帮了我们很多的忙，其中也有很多的快捷键可以提高我们开发的效率，但是这些快捷快捷键你都知道吗？

## 一、eclipse详解
以下是关于eclipse的中英对照，如果遇到不懂的地方可以做参考


「File」菜单
这个菜单可以建立、储存、关闭、打印、汇入及汇出工作台资源以及结束工作台本身。

名称 
 	功能 

New(新建) 
 	建立Java元素或新资源。配置哪些元素会显示在「Window」→「Preferences」的子菜单中。在Java视景中，依预设，会提供项目、套件、类别、接口、来源数据夹、实时运算簿、档案和数据夹的建立动作。 

Close(关闭) 
 	关闭现行编辑器。如果编辑器中有资料尚未储存，则会显示一个储存要求对话框。 

Close All(全部关闭) 
 	关闭所有编辑器。如果编辑器中有资料尚未储存，则会显示一个储存要求对话框。 

Save(储存) 
 	储存现行编辑器的内容。如果编辑器中没有未储存的变更，则会停用。 

Save As(另存新檔) 
 	以新名称储存现行编辑器中的内容。 

Save All(全部储存) 
 	储存所有编辑器内容以及未储存的变更。如果没有编辑器中有未储存的变更，则会停用。 

Revert(回复) 
 	将现行编辑器的内容回复成已储存档案中的内容。如果编辑器中没有未储存的变更，则会停用。 

Move(移动) 
 	移动资源。如果是Java元素则会停用。如果要移动Java元素，请使用「Refactor」→「Move」（如此会更新档案的所有参照），或使用「Edit」→「Cut/Paste」（如此不会更新参照）。 

Rename(重新命名) 
 	将资源重新命名。如果是Java元素则会停用。如果要重新命名Java元素，请使用「Refactor」→「Rename」（如此会更新档案的所有参照）。 

Refresh(重新整理) 
 	以本端档案系统来重新整理所选元素的内容。如果不是从特定选项启动，这个指令会重新整理所有项目。 

Print(打印) 
 	打印现行编辑器的内容。会在编辑器成为焦点时启用。 

Switch workspace(切换工作区) 
 	这个指令可以切换至不同的工作区这会重新启动工作台 

Open external file(开启外部档案) 
 	这个指令可以在文字编辑器中开启不在工作区中的档案 

Import(汇入) 
 	开启汇入精灵对话框。JDT不会提供任何汇入精灵。 

Export(汇出) 
 	开启汇出精灵对话框。JDT会提供JAR档汇出精灵和Javadoc产生精灵。 

Properties(内容) 
 	开启所选元素的「内容」页面。依据Java项目开启Java建置路径页面，且可使用Javadoc位置页面。如果是JAR保存文件，请在这个配置JAR的程序文件附加与Javadoc位置。 

Recent file list(最近使用的档案清单 
 	「File底端维护了一份最近在工作台中存取的档案的清单只要选取文件名，就可以从「File开启这其中的任何档案。 

Exit(结束) 
 	结束Eclipse 


「Edit」菜单
这个菜单可协助操作编辑器区域中的资源

名称 
 	功能 

Undo(复原) 
 	回复成编辑器中的前一次变更 

Redo(重做) 
 	回复已取消的变更 

Cut(剪下) 
 	将目前所选取的文字或元素复制到剪贴簿中，并移除元素。就元素而言，在贴到剪贴簿前不会移除。 

Copy(复制) 
 	将目前所选取的文字或元素复制到剪贴簿中。 

Paste (贴上) 
 	将目前的内容当成文字贴到编辑器中，或当成同层级或下层元素，贴到目前所选的元素中。 

Delete(删除) 
 	删除目前的文字或元素选项。 

Select All(全选) 
 	选取所有的编辑器内容。 

Find / Replace(寻找/取代) 
 	开启「寻找/取代」对话框。限编辑器。 

Find Next(寻找下一个) 
 	寻找目前所选文字下一个搜寻结果。限编辑器。 

Find Previous(寻找上一个) 
 	寻找目前所选文字上一个搜寻结果。限编辑器。 

Incremental Find Next(增量寻找下一个) 
 	启动增量寻找模式。在呼叫后，请按照状态列中的指示来输入搜寻文字。限编辑器。 

Incremental Find Previous(增量寻找上一个) 
 	启动增量寻找模式。在呼叫后，请按照状态列中的指示来输入搜寻文字。限编辑器。 

Add Bookmark(新增书签) 
 	为目前的文字选项或所选取的元素新增书签。 

Add Task(新增作业) 
 	为目前的文字选项或所选取的元素新增使用者定义的作业。 

Expand Selection to(展开选项至) 
 	n         含括元素：选取程序代码中的含括表示式、区块、方法。这个动作会注意Java语法。如果程序代码的语法有错，可能无法运作正常。（上移键） 

n         下一个元素：选取现行与下一个元素。（右移键）
n         上一个元素：选取现行与上一个元素（左移键）
n         还原前次的选择：在呼叫展开选项至之后，还原先前的选项。（下移键）
Show Tooltip Description(显示工具提示说明) 
 	以浮动说明方式显示出现在现行光标位置上的值。对话框可以卷动，因而不会缩短说明。 

Content Assist(内容辅助) 
 	在现行光标位置开启一个内容辅助对话框，以显示Java程序代码的辅助提议与范本。请参阅「模板」喜好设定页面，以取得可用的模板（「Window」→「Preferences」→「Java」→「Editor」→「Templates」），然后移至「编辑器」喜好设定页面（「Window」→「Preferences」→「Java」→「Editor」→「Code Assist」），来配置程序代码辅助的行为。 

Quick Fix(快速修正) 
 	如果光标位于有出现问题指示之处，则这个动作会在现行光标处开启一个内容辅助对话框，以提供可能的更正动作。 

Parameter Hints(参数提示) 
 	如果光标位于方法参照的参数规格处，这个动作会以浮动说明的方式显示参数类型信息。现行光标处的参数会以粗体字显示。 

Encoding(编码) 
 	切换目前所示文字内容的编码。 


「Source」菜单

名称 
 	功能 

Toggle Comment(批注) 
 	标注出内含现行选择项的所有字行。 

Add Block Comment(批注区块) 
 	标注出内含现行选择项的区块。 

Remove Block Comment(解除批注区块) 
 	取消标注内含现行选择项的区块。 

Shift Right(向右移位) 
 	增加目前所选字行的内缩层次。只有在选择项涵盖多行或一整行时才会启用。 

Shift Left(向左移位) 
 	减少目前所选字行的内缩层次。只有在选择项涵盖多行或一整行时才会启用。 

Format(格式) 
 	可使用程序代码格式制作器，来设定目前文字选择项的格式。格式设定选项是在「Code Formatter」喜好设定页面（「Window」→「Preferences」→「Java」→Code Formatter））中配置 

Format Element(格式成员) 
 	格式化成员 

Sort Members(排序成员) 
 	「Window」→「Preferences」→「Java」→「Appearance」→「Members Sort Order」中指定的排序次序，来排序类型中的成员 

Organize Imports(组织汇入) 
 	组织目前开启或所选编译单元中的汇入宣告。会移除不必要的汇入宣告，且会按照「Organize Import」喜好设定页面（「Window」→「Preferences」→「Java」→「Organize Import」）中的指定，来排列必要的汇入宣告。「Organize Import」可执行于不完整的程序文件上，并且会在所参照的类型名称无法唯一对映至现行项目中的某个类型时提示。 

也可以组织多个编译单元，其做法是对某个套件呼叫动作，或选取一组编译单元。
Add Import(新增汇入) 
 	为目前所选的类型参照建立一项汇入宣告。如果类型参照完整，则会移除资格。如果所参照的类型名称无法唯一对映至现行项目中的某个类型，将会提示指定正确的类型。「Add Import」会试着遵循「Organize Import」喜好设定页面中指定的汇入顺序。 

Override/Implement Methods(置换/实作方法) 
 	会开启「Override Method」对话框，可以置换或实作现行类型中的方法。适用于类型或类型中的某个文字选择项。 

Generate Getter and Setter(产生Getter和Setter) 
 	开启「Generate Getter and Setter」对话框，可以为现行类型中的字段，建立Getter和Setter。适用于字段与类型或类型中的某个文字选择项。 

Generate Delegate Methods(产生委派方法) 
 	开启「Generate Delegate Methods」对话框，可以为现行类型中的字段建立方法委派。可用在字段。 

Add Constructor from Superclass(新增Super类别中的建构子) 
 	为目前所选的类型新增Super类别中所定义的建构子。适用于类型或类型中的某个文字选择项。 

Surround with try/catch(以try/catch包覆) 
 	针对所选的陈述式，评估所有必须捕捉到的异常状况。这些表示式会包覆try catch区块。可以使用编辑菜单中的展开选项至，以取得有效的选项范围。 

Externalize Strings(将字符串提出) 
 	开启「Externalize Strings」精灵。这个精灵可以藉由会存取内容档的陈述式，来更换程序代码中的所有字符串。 

Find Strings to Externalize(寻找要提出的字符串) 
 	会出现一个对话框，其中显示未提出字符串数目的摘要。适用于项目、来源资料夹与套件。 

Convert Line Delimiters To(将行定界字符转换成) 
 	在目前开启的编辑器中，变更所有行定界字符，而采用下列操作系统中所用的行定界字符： 

n         CRLF(Windows)
n         LF（Unix、MacOSX）
n         CR（传统MacOS）
Java编辑器容许混合使用行定界字符。不过，其它某些工具会要求使用和OS一致的行定界字符，或者要求至少行定界字符要一致。

「Refactor」菜单
重构指令也可以在一些视图的快速菜单与Java编辑器中找到。

名称 
 	功能 

Undo(复原) 
 	「Undo」前次的重构作业。重构复原缓冲区，共在执行重构后程序文件未变更的状况下有效。 

Redo(重做) 
 	重做前次复原的重构作业。重构复原/重做缓冲区的有效期，仅限于执行重构后到没有其它程序文件变更的这段时间。 

Rename(重新命名) 
 	启动「Rename Refactoring」对话框：重新命名所选的元素，并且（如果有启用的话）更正元素的（以及其它档案中的）所有参照。适用于方法、字段、区域变量、方法参数、类型、编译单元、套件、来源数据夹、项目，并且适用于可解析成这些元素类型之一的文字选项。 

Move(移动) 
 	启动「Move」重构对话框：移动所选的元素，并（如果有启用的话）更正元素的（以及其它档案中的）所有参照。可套用至一或多个Static方法、Static字段、类型、编译单元、套件、来源数据夹与项目，并且套用于可解析成这些元素类型之一的文字选择项。 

Change Method Signature(变更方法签章) 
 	启动「Change Method Signature」重构对话框。变更参数名称、参数类型、参数顺序，并更新对应方法的所有参照。此外，可以移除或新增参数，也可以变更方法传回类型及其可见性。这个重构作业可套用至方法或套用在解析成方法的文字选项。 

Convert Anonymous Class to Nested(将匿名类别转换成巢状) 
 	启动「Convert Anonymous Class to Nested」重构对话框。协助将匿名内部类别转换成成员类别。这个重构作业可套用至匿名内部类别。 

Convert Nested Type to Top Level(将巢状类型转换成最上层) 
 	启动「Convert Nested Type to Top Level」重构对话框。为所选成员类型建立新的Java编译单元，同时依需要更新所有参照。对于非static成员类型，将新增一个字段，以容许存取先前含括的实例。这个重构作业可套用至成员类型或解析成成员类型的文字。 

Push Down(下推) 
 	启动「Push Down」重构对话框。将类别中的一组方法和字段移至它的子类别。这个重构作业可套用至一个或多个以相同类型宣告的方法和字段，或套用在字段或方法内的文字选项。 

Pull Up(上拉) 
 	启动「Pull Up」重构精灵。将字段或方法移至其宣告类别的Super类别，或（如果是方法）将方法宣告成Super类别中的abstract。这个重构作业可套用至一个或多个以相同类型宣告的方法、字段和成员类型，或套用在字段、方法或成员类型内的文字选项。 

Extract Interface(撷取界面) 
 	启动「Extract Interface」重构对话框。以一组方法建立新的接口，并使所选类别实作接口，同时选择性将类别参照变更为新接口（在可能的情况下）。这个重构作业可套用至类型。 

Use Supertype Where Possible(适当时使用Super类型) 
 	启动「Use Supertype Where Possible」重构对话框。在识别所有可能发生这个取代的位置后，将出现的类型换成其Super类型之一。这个重构作业可用在类型之上。 

Inline(列入) 
 	启动「Inline」重构对话框。列入区域变量、方法或常数。这个重构作业可用在方法、static final字段，以及解析为方法、static final字段或区域变量的文字选项。 

Extract Method(撷取方法) 
 	启动「Extract Method」重构对话框。会建立一个内含目前所选之陈述式或表示式的新方法，并将选择项换成新方法的参照。可以使用编辑菜单中的展开选项至，以取得有效的选项范围。
这项特性非常适合用来清除冗长、杂乱和太复杂的方法。 

Extract Local Variable(撷取区域变量) 
 	启动「Extract Local Variable」重构对话框。会建立一个新变量，以指定给目前所选的表示式，并将选择项换成新变量的参照。这个重构作业可用在解析为区域变量的文字选项。可以使用编辑菜单中的展开选项至，以取得有效的选项范围。 

Extract Constant(撷取常数) 
 	启动「Extract Constant」重构对话框。从所选表示式中建立static final字段并替代字段参照，以及选择性地重新写入其它出现相同表示式的位置。这个重构作业可用在static final字段，以及解析为static final字段的文字选项。 

Convert Local Variable to Field(将区域变量转换成字段) 
 	启动「Convert Local Variable to Field」重构对话框。将区域变量转换成字段。如果在建立时已起始设定变量，则作业会将起始设定移至新字段的宣告，或移至类别的建构子。这个重构作业可用在解析为区域变量的文字选项。 

Encapsulate Field(封装字段) 
 	启动「Encapsulate Field」重构对话框。会将字段的所有参照换成getting与setting方法。适用于所选的字段或可解析成字段的文字选择项。 


「Navigate」菜单
这个菜单可以寻找及导览工作台中显示的资源及其它成品。

名称 
 	功能 

Go Into(进入) 
 	将视图输入设定在目前所选的元素上。「套件浏览器」视图可支持这项。 

Go To(移至) 
 	n         上一页：将视图输入设定在历程中的上一个输入上：必须有历程，才能用到这项（已使用「Go Into」） 

n         下一页：将视图输入设定在历程中的下一个输入上：必须有历程，才能用到这项（已使用「Go Into」、「Go Into」→「Back」）
n         往上移一层：将现行视图的输入设定在其输入的母元素上。
n         参照测试：浏览以找出所有参照目前选取之类型的JUnit测试
n         类型：浏览以找出类型，并在现行视图中显示它。「Package Explorer」视图支援这项。
n         套件：浏览以找出套件，并在现行视图中显示它。「Package Explorer」视图支援这项。
n         资源：浏览以找出资源，并在现行视图中显示它。
Open(开启) 
 	试着解析现行程序代码选项上所参照的元素，并开启宣告该参照的档案。 

Open Type Hierarchy(开启类型阶层) 
 	试着解析现行程序代码选项上所参照的元素，并在「Type Hierarchy」视图中开启该元素。针对元素呼叫，并开启元素的类型阶层。显示Java元素的Java编辑器与视图中可支持这项。 

Open Call Hierarchy(开启呼叫阶层) 
 	试着开启呼叫现行程序代码选项上所参照的元素，并在「Call Hierarchy」视图中开启该元素。 

Open Super Implementation(开启super实作) 
 	开启一个编辑器，以显示目前所选方法或现行光标位置旁之方法的super实作。如果未选取方法，或者方法没有super实作，则不会开启编辑器。 

Open External Javadoc(开启外部Javadoc) 
 	开启目前所选元素或文字选项的Javadoc文件。JAR或项目的Javadoc位置是在项目或JAR的「Javadoc Location」内容页面中指定。请注意，这个外部Javadoc文件可能未以现行程序代码中指定的Javadoc加以更新。可以使用Javadoc汇出精灵，在Java项目中为程序文件建立Javadoc文件。 

Open Type(开启类型) 
 	显示「Open Type」选择对话框，以便在编辑器中开启一个类型。「开启类型」选择对话框中显示工作区中的所有现有类型。 

Open Type In Hierarchy(在「阶层」中开启类型) 
 	显示「Open Type」选择对话框，以便在编辑器与「Type Hierarchy」视图中开启一个类型。「Open Type」选择对话框中显示工作区中的所有现有类型。 

Show in → Package Explorer(显示在→套件浏览器) 
 	在「Package Explorer」视图中显示目前所选的元素（或现行光标位置旁的元素）。 

Quick Outline(显示概要) 
 	为目前选取的类型开启小型概要器。 

Quick Type Hierarchy(显示类型阶层) 
 	为目前选取的类型开启小型类型阶层器。 

Next Annotation (移至下一个问题) 
 	选取下一个问题。Java编辑器中支持这项。 

Previous Annotation (移至上一个问题) 
 	选取上一个问题。Java编辑器中支持这项。 

Go to Last Edit Location(移至前次编辑位置) 
 	显示前次发生编辑的位置。 

Go to Line(移至指定行号) 
 	开启对话框，以输入指示编辑器应移至的行号。限编辑器。 

Back(向后) 
 	这个指令会导览至之前在编辑器中检视的前一个资源。这个指令和Web浏览器的上一页按钮相同。 

Forward(向前 
 	这个指令会导览并复原之前的上一页指令所造成的效果。这个指令和Web浏览器的下一页按钮相同。 


「Search」菜单

名称 
 	功能 

Search...(搜寻...) 
 	开启搜寻对话框 

File...(档案...) 
 	针对「档案搜寻」页面开启搜寻对话框 

Java...(Java...) 
 	针对「Java搜寻」页面开启搜寻对话框 

References(参照) 
 	寻找所选Java元素的所有参照 

Declarations(宣告) 
 	寻找所选Java元素的所有宣告 

Implementors(实作者) 
 	寻找所选接口的所有实作者。 

Read Access(读取权) 
 	寻找所选字段的所有读取权 

Write Access(写入权) 
 	寻找所选字段的所有写入权 

Referring Tests...() 
 	寻找所选Java元素的所有测试参照 

Occurrences in File(档案中的搜寻结果) 
 	寻找所选Java元素在其档案中的所有出现项目 

Exception Occurrences(抛出例外中的搜寻结果) 
 	寻找所选Java元素在其抛出例外中的所有出现项目 

Search Scopes Submenu(搜寻范围子菜单)：

范围 
 	可用性 
 	说明 

Workspace(工作区) 
 	所有元素 
 	在整个工作区中搜寻 

Project(专案) 
 	所有元素 
 	在含括所选元素的项目中进行搜寻 

Hierarchy(阶层) 
 	类型和成员 
 	在类型的阶层中搜寻 

Workings Set(工作集) 
 	所有元素 
 	在工作集中搜寻 

工作集对话框可以储存并命名范围。「搜寻范围」子菜单中亦会显示工作集的现有实例。
可在下列视图中透过所选资源与元素的快速菜单，来执行Java搜寻：
n         「Package Explorer」
n         「Outline」视图
n         「Search Result」视图
n         「Hierarchy」视图
n         「Browsing」视图
Java编辑器中亦提供「Search」快速菜单。目前所选文字必须可解析成Java元素，才能执行搜寻。
所选Java元素的类型会定义所能使用的「Search」快速菜单。Java编辑器不会根据选项而限制可用的Java搜寻项清单。

「Project」菜单
「项目」菜单可以对工作台中的项目执行动作（建置或编译）。

名称 
 	功能 

Open Project(开启专案) 
 	显示对话框，可以选取开启已关闭的项目 

Close Project(关闭专案) 
 	关闭目前所选取的项目 

Build All(全部建置) 
 	这个指令会对工作台中的所有项目执行增量(incremental)建置。也就是说，它会建置（编译）自从前次增量建置后，工作台中受到任何资源变更所影响的所有资源。自动建置关闭时，才可使用这个指令。 

Build Project(建置专案) 
 	这个指令会对目前选取的项目执行增量(incremental)建置。也就是说，它会建置（编译）自从前次建置后，受到任何资源变更所影响的项目中的所有资源。自动建置关闭时，才可使用这个指令。 

Build Workings Set(重新建置工作集) 
 	这个菜单可以在工作集上执行增量(incremental)建置。也就是说，它会建置（编译）前次建置之后，受到任何资源变更所影响之工作集中的所有资源。自动建置关闭时，才可使用这个指令。 

Clean(清除) 
 	这个指令会舍弃先前的所有建置结果。如果自动建置是开启的，这会呼叫完整的建置。 

Build Automatically(自动建置) 
 	自动建置工作区中的所有项目。这个指令可以切换自动建置喜好设定。 

Generate Javadoc...(产生Javadoc...) 
 	对目前选取的项目开启「Generate Javadoc」精灵。 

Properties(内容) 
 	对目前选取的项目开启内容页面。 


「Run」菜单

名称 
 	功能 

Toggle Line Breakpoint(切换行岔断点) 
 	这个指令可以在目前于作用中Java编辑器中所选之行处，新增或移除Java行岔断点。 

Toggle Method Breakpoint(切换方法岔断点) 
 	这个指令可以针对目前的二进制方法，新增或移除方法岔断点。可在Java类别档编辑器的来源中选取二进制方法，或在其它任何视图中选取（像是「Outline」视图）。 

Toggle Watchpoint(切换监视点) 
 	这个指令可以针对目前的Java字段，新增或移除字段监视点。可在Java编辑器的来源中选取字段，或在其它任何视图中选取（像是「Outline」视图）。 

Skip All Breakpoints(忽略所有的岔断点) 
 	这个指令可以忽略所有的岔断点 

Add Java Exception Breakpoint(新增Java异常状况岔断点) 
 	这个指令可以建立一个异常状况岔断点。可藉由指定异常状况岔断点，而在掷出异常状况时，暂停执行绪或VM的执行。可设为在未捕捉到或捕捉到（或两者）异常状况时暂停执行。 

Add Class Load Breakpoint 
 	这个指令可让以建立一个Class Load岔断点。 

Run Last Launched(执行前一次的启动作业) 
 	这个指令可以在执行模式下迅速重复最近一次的启动作业（如果有支持该模式的话）。 

Debug Last Launched(除错前一次的启动作业) 
 	这个指令可以在除错模式下迅速重复最近一次的启动作业（如果有支持该模式的话）。 

Run History(执行历程) 
 	呈现在执行模式下启动的启动配置之最近历程的子菜单 

Run As(执行为) 
 	呈现所登录之执行启动快捷方式的子菜单。启动快捷方式可支持工作台或作用中编辑器选项的感应式启动。 

Run...(执行...) 
 	这个指令会了解启动配置对话框，以管理执行模式下的启动配置。 

Debug History(除错历程) 
 	呈现在除错模式下启动的启动配置之最近历程的子菜单 

Debug As(除错为) 
 	呈现所登录之除错启动快捷方式的子菜单。启动快捷方式可支持工作台或作用中编辑器选项的感应式启动。 

Debug...(除错...) 
 	这个指令会了解启动配置对话框，以管理除错模式下的启动配置。 

Inspect(视察) 
 	当执行绪暂停时，这个指令会使用「表示式」视图，显示在该执行绪之堆栈框或变量的环境定义下，视察所选表示式或变量的结果。 

Display(显示) 
 	当执行绪暂停时，这个指令会使用「Display」视图，显示在该执行绪之堆栈框或变量的环境定义下，评估所选表示式的结果。如果目前作用中的部分是「Java Snippet Editor(Java片段编辑器)」，则会在其中显示结果。 

Execute(执行) 
 	执行 

Step into Selection 
 	这些指令可以逐步执行所要除错的程序代码。 

Externakl Tools(外部工具) 
 	外部工具 


「Windows」菜单
这个菜单可以显示、隐藏，以及另行在工作台中操作各种视图、视景和动作。

名称 
 	功能 

New Window(开新窗口) 
 	这个指令会开启一个新的工作台窗口，其中含有与现行视景相同的视景。 

Open Perspective(开启视景) 
 	这个指令会在此工作台窗口中开启新视景。可以在「Window」→「Preferences」→「Workbench」→「Perspectives」页面中变更这个喜好设定。在工作台窗口内开启的所有视景都会显示在快捷方式列上。 

Show View(显示视图) 
 	这个指令会在现行视景中显示选取的视图。可以在「Window」→「Preferences」→「Workbench」→「Perspectives」页面中配置开启视图的方式。可能会想开启的视图会最先列示；这份清单视现行视景而定。从其它... 子菜单中，可以开启任何视图。视图会依照「Show View」对话框中的各个种类来排序。 

Customize Perspective(自订视景) 
 	每个视景包含一组预先定义的动作，可以从菜单列和工作台工具列存取这些动作。  

Save Perspective As(另存新视景) 
 	这个指令可以储存现行视景，以及建立自己的自订视景。储存视景之后，可以使用「Window」→「Show View」→「Other...」菜单项目来开启更多这类型的视景。 

Reset Perspective(重设视景) 
 	这个指令会将现行视景的布置变更为其原始的配置。 

Close Perspective(关闭视景) 
 	这个指令会关闭作用中的视景。 

Close All Perspectives(关闭所有视景) 
 	这个指令会关闭工作台窗口中的所有已开启视景。 

Navigation(导览)        
 	这个子菜单包含用于在工作台窗口中的视图、视景及编辑器之间导览的按键。 

n         显示系统菜单：显示用来重新调整大小、关闭或固定现行视图或编辑器的菜单。
n         显示视图菜单：显示可在作用中视图的工具列中存取的下拉菜单。
n         将作用中的视图或编辑器最大化：使作用中的部分占用整个画面，如果已占用整个画面，就使它返回原始状态。
n         启动编辑器：使现行编辑器作用中。
n         下一个编辑器：启动最近使用的编辑器清单中的下一个开启的编辑器。
n         上一个编辑器：启动最近使用的编辑器清单中的上一个开启的编辑器。
n         切换至编辑器：显示一个对话框，用来切换到已开启的编辑器。显示一个对话框，用来切换到已开启的编辑器。
n         下一个视图：启动最近使用的视图清单中的下一个开启的视图。
n         上一个视图：启动最近使用的编辑器清单中的上一个开启的编辑器。
n         下一个视景：启动最近使用的视景清单中的下一个开启的视景。
n         上一个视景：启动最近使用的视景清单中的上一个开启的视景。
Preferences(喜好设定) 
 	这个指令可以指出在使用工作台时的喜好设定。其中有各式各样的喜好设定可用来配置工作台及其视图的外观，以及用来自订在工作台中安装的所有工具的行为。 


「Help」菜单
这个指令提供有关使用工作台的说明。


下面是一些快捷键的用法：
下面是一些快捷键的用法：
名称 
 	功能 

Welcome(欢迎使用) 
 	这个指令会开启欢迎使用内容。 

Help Contents(说明内容) 
 	这个指令显示说明视图。说明视图含有说明书籍、主题，以及与工作台和已安装特性的相关信息。 

Tips and Tricks(要诀和技巧) 
 	这个指令会开启可能尚未探索之有兴趣的生产力特性的清单。 

Cheat Sheets(提要) 
 	这个指令会开启选取提要的对话框。 

Software Updates(软件更新) 
 	这个指令群组可以更新产品以及下载及安装新特性。 

About Eclipse Platform(关于Eclipse平台) 
 	这个指令显示产品、已安装特性及可用外挂程序的相关信息。 

 ## 二、eclipse中最常用的快捷键

一、常用系列：
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171709586.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
二、查看和定位快捷键系列
在程序中，迅速定位代码的位置，快速找到 Bug 的所在，是非常不容易的事，Eclipse 提供了强大的查找功能，可以利用如下的快捷键帮助完成查找定位的工作。

 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171722276.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2018120817175556.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)

三、调试快捷键系列
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171814403.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)



四、常用编辑器快捷键系列
通常文本编辑器都提供了一些和编辑相关的快捷键，在 Eclipse 中也可以通过这些快捷键进行文本编辑。
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171828783.png)
五、切换系列
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171835278.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
六、Ctrl系列
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171843980.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
七、Ctrl+Shift系列
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171850337.png)
八、F 快捷键系列
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171858713.png)
九、行编辑用系列
 ![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171903262.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
十、不常用系列
![在这里插入图片描述](https://img-blog.csdnimg.cn/20181208171910875.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQzMjcwMDc0,size_16,color_FFFFFF,t_70)
------
# 本文章已同步至GitHub仓库：<a href="Javasthttps://github.com/freestylefly/javaStudyudy">Javastudy</a>,期待您的加入:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/github.jpg" width=""/>

# 本文章已同步至<a href="https://freestylefly.github.io/">苍何的个人博客</a>,可以直接在博客上留言哦:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/myblog..png" width=""/>

# 来我的微信公众号玩耍呗:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/weixingongzhonghao.jpg" width=""/>

# 扫码无套路关注我的CSDN博客:blush:
<img src="http://pp8g2fyug.bkt.clouddn.com/CSDN.png" width=""/>