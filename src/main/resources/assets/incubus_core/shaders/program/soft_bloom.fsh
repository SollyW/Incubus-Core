#version 150

#define RADIUS 15

in vec2 texCoord;
in vec2 oneTexel;

uniform sampler2D DiffuseSampler;
uniform sampler2D LightSourceSampler;

out vec4 fragColor;

void main() {
    vec3 blur = vec3(0);

    float intensity = texture(LightSourceSampler, texCoord).a;
    float radius = floor(RADIUS + intensity * 15);
    for (float x = -radius; x <= radius; x += 1) {
        for (float y = -radius; y <= radius; y += 1) {
            if (x * x + y * y <= radius * radius) {
                blur += texture(LightSourceSampler, texCoord + vec2(x, y) * oneTexel).rgb;
            }
        }
    }
    float samples = radius * 2 + 1;
    blur /= samples * samples;

    fragColor = vec4(texture(DiffuseSampler, texCoord).rgb + blur, 1);
}
