<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
<databrowser>
    <title></title>
    <save_changes>false</save_changes>
    <show_legend>false</show_legend>
    <show_toolbar>true</show_toolbar>
    <grid>false</grid>
    <scroll>true</scroll>
    <update_period>1.0</update_period>
    <scroll_step>5</scroll_step>
    <start>-1.95 min</start>
    <end>now</end>
    <archive_rescale>NONE</archive_rescale>
    <background>
        <red>255</red>
        <green>255</green>
        <blue>255</blue>
    </background>
    <title_font>Liberation Sans|15|1</title_font>
    <label_font>Liberation Sans|14|1</label_font>
    <scale_font>Liberation Sans|14|0</scale_font>
    <legend_font>Liberation Sans|14|0</legend_font>
    <axes>
        <axis>
            <visible>true</visible>
            <name>Temperatures</name>
            <use_axis_name>false</use_axis_name>
            <use_trace_names>true</use_trace_names>
            <right>false</right>
            <color>
                <red>0</red>
                <green>0</green>
                <blue>0</blue>
            </color>
            <min>-0.31737642202759275</min>
            <max>99.68262357797241</max>
            <grid>false</grid>
            <autoscale>false</autoscale>
            <log_scale>false</log_scale>
        </axis>
        <axis>
            <visible>true</visible>
            <name>Voltage</name>
            <use_axis_name>false</use_axis_name>
            <use_trace_names>true</use_trace_names>
            <right>false</right>
            <color>
                <red>0</red>
                <green>0</green>
                <blue>0</blue>
            </color>
            <min>-0.3491140642303492</min>
            <max>109.65088593576965</max>
            <grid>false</grid>
            <autoscale>false</autoscale>
            <log_scale>false</log_scale>
        </axis>
    </axes>
    <annotations>
    </annotations>
    <pvlist>
        <pv>
            <display_name>Tank Temp.</display_name>
            <visible>true</visible>
            <name>$(user):tank</name>
            <axis>0</axis>
            <color>
                <red>21</red>
                <green>21</green>
                <blue>196</blue>
            </color>
            <trace_type>AREA</trace_type>
            <linewidth>4</linewidth>
            <point_type>NONE</point_type>
            <point_size>2</point_size>
            <waveform_index>0</waveform_index>
            <period>0.0</period>
            <ring_size>5000</ring_size>
            <request>OPTIMIZED</request>
        </pv>
        <pv>
            <display_name>Setpoint</display_name>
            <visible>true</visible>
            <name>$(user):setpoint</name>
            <axis>0</axis>
            <color>
                <red>242</red>
                <green>26</green>
                <blue>26</blue>
            </color>
            <trace_type>AREA</trace_type>
            <linewidth>2</linewidth>
            <point_type>NONE</point_type>
            <point_size>2</point_size>
            <waveform_index>0</waveform_index>
            <period>0.0</period>
            <ring_size>5000</ring_size>
            <request>OPTIMIZED</request>
        </pv>
        <pv>
            <display_name>Heater Volt.</display_name>
            <visible>true</visible>
            <name>$(user):heat_V</name>
            <axis>1</axis>
            <color>
                <red>128</red>
                <green>0</green>
                <blue>64</blue>
            </color>
            <trace_type>AREA</trace_type>
            <linewidth>3</linewidth>
            <point_type>NONE</point_type>
            <point_size>2</point_size>
            <waveform_index>0</waveform_index>
            <period>0.0</period>
            <ring_size>5000</ring_size>
            <request>OPTIMIZED</request>
        </pv>
    </pvlist>
</databrowser>