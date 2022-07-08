# Here you can create play commands that are specific to the module, and extend existing commands
import sys
import inspect
import os
import subprocess
import shutil

from play.utils import *

MODULE = 'doma'

# Commands that are specific to your module

COMMANDS = []

def execute(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")

    if command == "doma:hello":
        print("~ Hello")


# This will be executed before any command (new, run...)
def before(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")


# This will be executed after any command (new, run...)
def after(**kargs):
    command = kargs.get("command")
    app = kargs.get("app")
    args = kargs.get("args")
    env = kargs.get("env")

    if command == 'ec' or command == 'eclipsify':
        module_dir = inspect.getfile(inspect.currentframe()).replace("commands.py", "")
        shutil.copyfile(os.path.join(module_dir, 'resources', 'org.eclipse.jdt.apt.core.prefs'), os.path.join(app.path, '.settings', 'org.eclipse.jdt.apt.core.prefs'))
        shutil.copyfile(os.path.join(module_dir, 'resources', '.factorypath'), os.path.join(app.path, '.factorypath'))
        
        jarPath = searchJar(app.path, module_dir)
        dotFactoryPath = os.path.join(app.path, '.factorypath')
        replaceAll(dotFactoryPath, r'<factorypathentry />', '<factorypathentry kind="EXTJAR" id="%s" enabled="true" runInBatchMode="false"/>' % jarPath)
        
        dotSettings = os.path.join(app.path, '.settings')
        corePrefs = open(os.path.join(dotSettings, 'org.eclipse.jdt.core.prefs'), 'a')
        corePrefs.write('org.eclipse.jdt.core.compiler.processAnnotations=enabled')
        corePrefs.close()
        
        dotClassPath = os.path.join(app.path, '.classpath')
        replaceAll(dotClassPath, r'</classpath>', '''	<classpathentry kind="src" path=".apt_generated">
        <attributes>
            <attribute name="optional" value="true"/>
        </attributes>
    </classpathentry>
</classpath>''')

def searchJar(appPath, modulePath):
    for root, dirs, files in os.walk(os.path.join(appPath, 'lib')):
        for fileName in files:
            if re.compile('doma-\S+.jar').match(fileName):
                return os.path.join(appPath, 'lib', fileName)
    for root, dirs, files in os.walk(os.path.join(modulePath, 'lib')):
        for fileName in files:
            if re.compile('doma-\S+.jar').match(fileName):
                return os.path.join(modulePath, 'lib', fileName)
    return ''


