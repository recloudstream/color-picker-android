# Color Picker

<img src="https://github.com/jaredrummler/ColorPicker/blob/master/demo/src/main/res/mipmap-xxxhdpi/ic_launcher.png?raw=true" align="left" hspace="10" vspace="10"></a>

Yet another open source color picker for Android. So, why should you use this color picker? It is highly customizable and easy to use. You can simply add the `ColorPickerPreference` to your preferences and a beautiful color picker dialog will be displayed without additional code. The color picker supports alpha and allows you to set your own presets.

The original ColorPickerView was written by [Daniel Nilsson](https://github.com/danielnilsson9/color-picker-view).

## Screenshots
![GIF](art/demo.gif)
&nbsp;&nbsp;
<img src="art/screenshot3.png" width="300" alt="Screenshot">

## Usage

Add the `ColorPickerPreference` to your preference XML:

```xml
<PreferenceScreen xmlns:android="http://schemas.android.com/apk/res/android"
                  xmlns:app="http://schemas.android.com/apk/res-auto">

  <PreferenceCategory>

    <com.jaredrummler.android.colorpicker.ColorPickerPreference
        android:defaultValue="@color/color_default"
        android:key="default_color"
        android:summary="@string/color_default_summary"
        android:title="@string/color_default_title"/>

    ...

  </PreferenceCategory>

</PreferenceScreen>
```

You can add attributes to customize the `ColorPickerPreference`:

| name                | type      | documentation                                                                         |
|---------------------|-----------|---------------------------------------------------------------------------------------|
| cpv_dialogType      | enum      | "custom" to show the color picker, "preset" to show pre-defined colors                |
| cpv_showAlphaSlider | boolean   | Show a slider for changing the alpha of a color (adding transparency)                 |
| cpv_colorShape      | enum      | "square" or "circle" for the shape of the color preview                               |
| cpv_colorPresets    | reference | An int-array of pre-defined colors to show in the dialog                              |
| cpv_dialogTitle     | reference | The string resource id for the dialog title. By default the title is "Select a Color" |
| cpv_showColorShades | boolean   | true to show different shades of the selected color                                   |
| cpv_allowPresets    | boolean   | true to add a button to toggle to the custom color picker                             |
| cpv_allowCustom     | boolean   | true to add a button to toggle to the presets color picker                            |
| cpv_showDialog      | boolean   | true to let the ColorPickerPreference handle showing the dialog                       |

You can also show a `ColorPickerDialog` without using the `ColorPickerPreference`:

```java
ColorPickerDialog.newBuilder().setColor(color).show(activity);
```

All the attributes above can also be applied to the `ColorPickerDialog`. The activity that shows the dialog *must* 
implement `ColorPickerDialogListener` to get a callback when a color is selected.

For further documentation about how to use the library, check the [demo](demo) app included in this project.

## Download

1. Add JitPack to top level 'build.gradle' file
```
allprojects {
    repositories {
        ...
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

2. Add dependency to the module 'build.gradle'
```
dependencies {
    ...
    ....
    implementation 'com.github.sagishporer:color-picker-android:1.3.7'
}
```

## License

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
