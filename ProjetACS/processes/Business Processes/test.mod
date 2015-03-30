[Ivy]
[>Created: Mon Mar 30 17:47:50 CEST 2015]
14C6B51DCB2D1C38 3.17 #module
>Proto >Proto Collection #zClass
tt0 test Big #zClass
tt0 B #cInfo
tt0 #process
tt0 @TextInP .resExport .resExport #zField
tt0 @TextInP .type .type #zField
tt0 @TextInP .processKind .processKind #zField
tt0 @AnnotationInP-0n ai ai #zField
tt0 @MessageFlowInP-0n messageIn messageIn #zField
tt0 @MessageFlowOutP-0n messageOut messageOut #zField
tt0 @TextInP .xml .xml #zField
tt0 @TextInP .responsibility .responsibility #zField
tt0 @StartRequest f0 '' #zField
tt0 @EndTask f1 '' #zField
tt0 @PushWFArc f2 '' #zField
tt0 @IntermediateEvent f3 '' #zField
>Proto tt0 tt0 test #zField
tt0 f0 outLink start.ivp #txt
tt0 f0 type projetACS.Data #txt
tt0 f0 inParamDecl '<> param;' #txt
tt0 f0 actionDecl 'projetACS.Data out;
' #txt
tt0 f0 guid 14C6B51DCC275C83 #txt
tt0 f0 requestEnabled true #txt
tt0 f0 triggerEnabled false #txt
tt0 f0 callSignature start() #txt
tt0 f0 @C|.xml '<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<elementInfo>
    <language>
        <name>start.ivp</name>
    </language>
</elementInfo>
' #txt
tt0 f0 @C|.responsibility Everybody #txt
tt0 f0 81 49 30 30 -21 17 #rect
tt0 f0 @|StartRequestIcon #fIcon
tt0 f1 type projetACS.Data #txt
tt0 f1 337 49 30 30 0 15 #rect
tt0 f1 @|EndIcon #fIcon
tt0 f2 111 64 337 64 #arcP
tt0 f3 actionDecl 'projetACS.Data out;
' #txt
tt0 f3 actionTable 'out=in;
' #txt
tt0 f3 outLink TaskA.ivp #txt
tt0 f3 type projetACS.Data #txt
tt0 f3 361 241 30 30 0 16 #rect
tt0 f3 @|IntermediateEventIcon #fIcon
>Proto tt0 .type projetACS.Data #txt
>Proto tt0 .processKind NORMAL #txt
>Proto tt0 0 0 32 24 18 0 #rect
>Proto tt0 @|BIcon #fIcon
tt0 f0 mainOut f2 tail #connect
tt0 f2 head f1 mainIn #connect
