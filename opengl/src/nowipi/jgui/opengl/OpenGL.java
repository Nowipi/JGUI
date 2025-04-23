package nowipi.jgui.opengl;

import java.lang.foreign.*;

import static java.lang.foreign.ValueLayout.JAVA_BYTE;

public final class OpenGL {

    public static final ValueLayout.OfBoolean GLboolean = ValueLayout.JAVA_BOOLEAN;
    public static final ValueLayout.OfByte GLbyte 	= ValueLayout.JAVA_BYTE;
    public static final ValueLayout.OfByte GLubyte = GLbyte;
    public static final ValueLayout.OfByte GLchar = GLbyte;
    public static final ValueLayout.OfShort GLshort = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfShort GLushort = GLshort;
    public static final ValueLayout.OfInt GLint = ValueLayout.JAVA_INT;
    public static final ValueLayout.OfInt GLuint = GLint;
    public static final ValueLayout.OfInt GLfixed =	GLint;
    public static final ValueLayout.OfLong GLint64 = ValueLayout.JAVA_LONG;
    public static final ValueLayout.OfLong GLuint64 = GLint64;
    public static final ValueLayout.OfInt GLsizei = GLint;
    public static final ValueLayout.OfInt GLenum = GLint;
    public static final AddressLayout GLintptr =	ValueLayout.ADDRESS
            .withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));
    public static final ValueLayout.OfInt GLsizeiptr = GLsizei;
    public static final AddressLayout GLsync = GLintptr;
    public static final ValueLayout.OfInt GLbitfield = GLint;
    public static final ValueLayout.OfShort GLhalf = ValueLayout.JAVA_SHORT;
    public static final ValueLayout.OfFloat GLfloat = ValueLayout.JAVA_FLOAT;
    public static final ValueLayout.OfFloat GLclampf = GLfloat;
    public static final ValueLayout.OfDouble GLdouble = ValueLayout.JAVA_DOUBLE;
    public static final ValueLayout.OfDouble GLclampd = GLdouble;
    public static final AddressLayout POINTER =	ValueLayout.ADDRESS
            .withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, JAVA_BYTE));

    public static final int GL_2D = 0x600;
    public static final int GL_2_BYTES = 0x1407;
    public static final int GL_3D = 0x601;
    public static final int GL_3D_COLOR = 0x602;
    public static final int GL_3D_COLOR_TEXTURE = 0x603;
    public static final int GL_3_BYTES = 0x1408;
    public static final int GL_4D_COLOR_TEXTURE = 0x604;
    public static final int GL_4_BYTES = 0x1409;
    public static final int GL_ACCUM = 0x100;
    public static final int GL_ACCUM_ALPHA_BITS = 0xd5b;
    public static final int GL_ACCUM_BLUE_BITS = 0xd5a;
    public static final int GL_ACCUM_BUFFER_BIT = 0x200;
    public static final int GL_ACCUM_CLEAR_VALUE = 0xb80;
    public static final int GL_ACCUM_GREEN_BITS = 0xd59;
    public static final int GL_ACCUM_RED_BITS = 0xd58;
    public static final int GL_ACTIVE_ATOMIC_COUNTER_BUFFERS = 0x92d9;
    public static final int GL_ACTIVE_ATTRIBUTES = 0x8b89;
    public static final int GL_ACTIVE_ATTRIBUTE_MAX_LENGTH = 0x8b8a;
    public static final int GL_ACTIVE_PROGRAM = 0x8259;
    public static final int GL_ACTIVE_RESOURCES = 0x92f5;
    public static final int GL_ACTIVE_SUBROUTINES = 0x8de5;
    public static final int GL_ACTIVE_SUBROUTINE_MAX_LENGTH = 0x8e48;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORMS = 0x8de6;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_LOCATIONS = 0x8e47;
    public static final int GL_ACTIVE_SUBROUTINE_UNIFORM_MAX_LENGTH = 0x8e49;
    public static final int GL_ACTIVE_TEXTURE = 0x84e0;
    public static final int GL_ACTIVE_UNIFORMS = 0x8b86;
    public static final int GL_ACTIVE_UNIFORM_BLOCKS = 0x8a36;
    public static final int GL_ACTIVE_UNIFORM_BLOCK_MAX_NAME_LENGTH = 0x8a35;
    public static final int GL_ACTIVE_UNIFORM_MAX_LENGTH = 0x8b87;
    public static final int GL_ACTIVE_VARIABLES = 0x9305;
    public static final int GL_ADD = 0x104;
    public static final int GL_ALIASED_LINE_WIDTH_RANGE = 0x846e;
    public static final int GL_ALL_ATTRIB_BITS = 0xfffff;
    public static final int GL_ALPHA = 0x1906;
    public static final int GL_ALPHA12 = 0x803d;
    public static final int GL_ALPHA16 = 0x803e;
    public static final int GL_ALPHA4 = 0x803b;
    public static final int GL_ALPHA8 = 0x803c;
    public static final int GL_ALPHA_BIAS = 0xd1d;
    public static final int GL_ALPHA_BITS = 0xd55;
    public static final int GL_ALPHA_SCALE = 0xd1c;
    public static final int GL_ALPHA_TEST = 0xbc0;
    public static final int GL_ALPHA_TEST_FUNC = 0xbc1;
    public static final int GL_ALPHA_TEST_REF = 0xbc2;
    public static final int GL_ALREADY_SIGNALED = 0x911a;
    public static final int GL_ALWAYS = 0x207;
    public static final int GL_AMBIENT = 0x1200;
    public static final int GL_AMBIENT_AND_DIFFUSE = 0x1602;
    public static final int GL_AND = 0x1501;
    public static final int GL_AND_INVERTED = 0x1504;
    public static final int GL_AND_REVERSE = 0x1502;
    public static final int GL_ANY_SAMPLES_PASSED = 0x8c2f;
    public static final int GL_ANY_SAMPLES_PASSED_CONSERVATIVE = 0x8d6a;
    public static final int GL_ARRAY_BUFFER = 0x8892;
    public static final int GL_ARRAY_BUFFER_BINDING = 0x8894;
    public static final int GL_ARRAY_SIZE = 0x92fb;
    public static final int GL_ARRAY_STRIDE = 0x92fe;
    public static final int GL_ATOMIC_COUNTER_BARRIER_BIT = 0x1000;
    public static final int GL_ATOMIC_COUNTER_BUFFER = 0x92c0;
    public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTERS = 0x92c5;
    public static final int GL_ATOMIC_COUNTER_BUFFER_ACTIVE_ATOMIC_COUNTER_INDICES = 0x92c6;
    public static final int GL_ATOMIC_COUNTER_BUFFER_BINDING = 0x92c1;
    public static final int GL_ATOMIC_COUNTER_BUFFER_DATA_SIZE = 0x92c4;
    public static final int GL_ATOMIC_COUNTER_BUFFER_INDEX = 0x9301;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_COMPUTE_SHADER = 0x90ed;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_FRAGMENT_SHADER = 0x92cb;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_GEOMETRY_SHADER = 0x92ca;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_CONTROL_SHADER = 0x92c8;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x92c9;
    public static final int GL_ATOMIC_COUNTER_BUFFER_REFERENCED_BY_VERTEX_SHADER = 0x92c7;
    public static final int GL_ATOMIC_COUNTER_BUFFER_SIZE = 0x92c3;
    public static final int GL_ATOMIC_COUNTER_BUFFER_START = 0x92c2;
    public static final int GL_ATTACHED_SHADERS = 0x8b85;
    public static final int GL_ATTRIB_STACK_DEPTH = 0xbb0;
    public static final int GL_AUTO_GENERATE_MIPMAP = 0x8295;
    public static final int GL_AUTO_NORMAL = 0xd80;
    public static final int GL_AUX0 = 0x409;
    public static final int GL_AUX1 = 0x40a;
    public static final int GL_AUX2 = 0x40b;
    public static final int GL_AUX3 = 0x40c;
    public static final int GL_AUX_BUFFERS = 0xc00;
    public static final int GL_BACK = 0x405;
    public static final int GL_BACK_LEFT = 0x402;
    public static final int GL_BACK_RIGHT = 0x403;
    public static final int GL_BGR = 0x80e0;
    public static final int GL_BGRA = 0x80e1;
    public static final int GL_BGRA_EXT = 0x80e1;
    public static final int GL_BGRA_INTEGER = 0x8d9b;
    public static final int GL_BGR_EXT = 0x80e0;
    public static final int GL_BGR_INTEGER = 0x8d9a;
    public static final int GL_BITMAP = 0x1a00;
    public static final int GL_BITMAP_TOKEN = 0x704;
    public static final int GL_BLEND = 0xbe2;
    public static final int GL_BLEND_COLOR = 0x8005;
    public static final int GL_BLEND_DST = 0xbe0;
    public static final int GL_BLEND_DST_ALPHA = 0x80ca;
    public static final int GL_BLEND_DST_RGB = 0x80c8;
    public static final int GL_BLEND_EQUATION = 0x8009;
    public static final int GL_BLEND_EQUATION_ALPHA = 0x883d;
    public static final int GL_BLEND_EQUATION_RGB = 0x8009;
    public static final int GL_BLEND_SRC = 0xbe1;
    public static final int GL_BLEND_SRC_ALPHA = 0x80cb;
    public static final int GL_BLEND_SRC_RGB = 0x80c9;
    public static final int GL_BLOCK_INDEX = 0x92fd;
    public static final int GL_BLUE = 0x1905;
    public static final int GL_BLUE_BIAS = 0xd1b;
    public static final int GL_BLUE_BITS = 0xd54;
    public static final int GL_BLUE_INTEGER = 0x8d96;
    public static final int GL_BLUE_SCALE = 0xd1a;
    public static final int GL_BOOL = 0x8b56;
    public static final int GL_BOOL_VEC2 = 0x8b57;
    public static final int GL_BOOL_VEC3 = 0x8b58;
    public static final int GL_BOOL_VEC4 = 0x8b59;
    public static final int GL_BUFFER = 0x82e0;
    public static final int GL_BUFFER_ACCESS = 0x88bb;
    public static final int GL_BUFFER_ACCESS_FLAGS = 0x911f;
    public static final int GL_BUFFER_BINDING = 0x9302;
    public static final int GL_BUFFER_DATA_SIZE = 0x9303;
    public static final int GL_BUFFER_IMMUTABLE_STORAGE = 0x821f;
    public static final int GL_BUFFER_MAPPED = 0x88bc;
    public static final int GL_BUFFER_MAP_LENGTH = 0x9120;
    public static final int GL_BUFFER_MAP_OFFSET = 0x9121;
    public static final int GL_BUFFER_MAP_POINTER = 0x88bd;
    public static final int GL_BUFFER_SIZE = 0x8764;
    public static final int GL_BUFFER_STORAGE_FLAGS = 0x8220;
    public static final int GL_BUFFER_UPDATE_BARRIER_BIT = 0x200;
    public static final int GL_BUFFER_USAGE = 0x8765;
    public static final int GL_BUFFER_VARIABLE = 0x92e5;
    public static final int GL_BYTE = 0x1400;
    public static final int GL_C3F_V3F = 0x2a24;
    public static final int GL_C4F_N3F_V3F = 0x2a26;
    public static final int GL_C4UB_V2F = 0x2a22;
    public static final int GL_C4UB_V3F = 0x2a23;
    public static final int GL_CAVEAT_SUPPORT = 0x82b8;
    public static final int GL_CCW = 0x901;
    public static final int GL_CLAMP = 0x2900;
    public static final int GL_CLAMP_READ_COLOR = 0x891c;
    public static final int GL_CLAMP_TO_BORDER = 0x812d;
    public static final int GL_CLAMP_TO_EDGE = 0x812f;
    public static final int GL_CLEAR = 0x1500;
    public static final int GL_CLEAR_BUFFER = 0x82b4;
    public static final int GL_CLEAR_TEXTURE = 0x9365;
    public static final int GL_CLIENT_ATTRIB_STACK_DEPTH = 0xbb1;
    public static final int GL_CLIENT_MAPPED_BUFFER_BARRIER_BIT = 0x4000;
    public static final int GL_CLIENT_PIXEL_STORE_BIT = 0x1;
    public static final int GL_CLIENT_STORAGE_BIT = 0x200;
    public static final int GL_CLIENT_VERTEX_ARRAY_BIT = 0x2;
    public static final int GL_CLIPPING_INPUT_PRIMITIVES_ARB = 0x82f6;
    public static final int GL_CLIPPING_OUTPUT_PRIMITIVES_ARB = 0x82f7;
    public static final int GL_CLIP_DEPTH_MODE = 0x935d;
    public static final int GL_CLIP_DISTANCE0 = 0x3000;
    public static final int GL_CLIP_DISTANCE1 = 0x3001;
    public static final int GL_CLIP_DISTANCE2 = 0x3002;
    public static final int GL_CLIP_DISTANCE3 = 0x3003;
    public static final int GL_CLIP_DISTANCE4 = 0x3004;
    public static final int GL_CLIP_DISTANCE5 = 0x3005;
    public static final int GL_CLIP_DISTANCE6 = 0x3006;
    public static final int GL_CLIP_DISTANCE7 = 0x3007;
    public static final int GL_CLIP_ORIGIN = 0x935c;
    public static final int GL_CLIP_PLANE0 = 0x3000;
    public static final int GL_CLIP_PLANE1 = 0x3001;
    public static final int GL_CLIP_PLANE2 = 0x3002;
    public static final int GL_CLIP_PLANE3 = 0x3003;
    public static final int GL_CLIP_PLANE4 = 0x3004;
    public static final int GL_CLIP_PLANE5 = 0x3005;
    public static final int GL_COEFF = 0xa00;
    public static final int GL_COLOR = 0x1800;
    public static final int GL_COLOR_ARRAY = 0x8076;
    public static final int GL_COLOR_ARRAY_COUNT_EXT = 0x8084;
    public static final int GL_COLOR_ARRAY_EXT = 0x8076;
    public static final int GL_COLOR_ARRAY_POINTER = 0x8090;
    public static final int GL_COLOR_ARRAY_POINTER_EXT = 0x8090;
    public static final int GL_COLOR_ARRAY_SIZE = 0x8081;
    public static final int GL_COLOR_ARRAY_SIZE_EXT = 0x8081;
    public static final int GL_COLOR_ARRAY_STRIDE = 0x8083;
    public static final int GL_COLOR_ARRAY_STRIDE_EXT = 0x8083;
    public static final int GL_COLOR_ARRAY_TYPE = 0x8082;
    public static final int GL_COLOR_ARRAY_TYPE_EXT = 0x8082;
    public static final int GL_COLOR_ATTACHMENT0 = 0x8ce0;
    public static final int GL_COLOR_ATTACHMENT1 = 0x8ce1;
    public static final int GL_COLOR_ATTACHMENT10 = 0x8cea;
    public static final int GL_COLOR_ATTACHMENT11 = 0x8ceb;
    public static final int GL_COLOR_ATTACHMENT12 = 0x8cec;
    public static final int GL_COLOR_ATTACHMENT13 = 0x8ced;
    public static final int GL_COLOR_ATTACHMENT14 = 0x8cee;
    public static final int GL_COLOR_ATTACHMENT15 = 0x8cef;
    public static final int GL_COLOR_ATTACHMENT16 = 0x8cf0;
    public static final int GL_COLOR_ATTACHMENT17 = 0x8cf1;
    public static final int GL_COLOR_ATTACHMENT18 = 0x8cf2;
    public static final int GL_COLOR_ATTACHMENT19 = 0x8cf3;
    public static final int GL_COLOR_ATTACHMENT2 = 0x8ce2;
    public static final int GL_COLOR_ATTACHMENT20 = 0x8cf4;
    public static final int GL_COLOR_ATTACHMENT21 = 0x8cf5;
    public static final int GL_COLOR_ATTACHMENT22 = 0x8cf6;
    public static final int GL_COLOR_ATTACHMENT23 = 0x8cf7;
    public static final int GL_COLOR_ATTACHMENT24 = 0x8cf8;
    public static final int GL_COLOR_ATTACHMENT25 = 0x8cf9;
    public static final int GL_COLOR_ATTACHMENT26 = 0x8cfa;
    public static final int GL_COLOR_ATTACHMENT27 = 0x8cfb;
    public static final int GL_COLOR_ATTACHMENT28 = 0x8cfc;
    public static final int GL_COLOR_ATTACHMENT29 = 0x8cfd;
    public static final int GL_COLOR_ATTACHMENT3 = 0x8ce3;
    public static final int GL_COLOR_ATTACHMENT30 = 0x8cfe;
    public static final int GL_COLOR_ATTACHMENT31 = 0x8cff;
    public static final int GL_COLOR_ATTACHMENT4 = 0x8ce4;
    public static final int GL_COLOR_ATTACHMENT5 = 0x8ce5;
    public static final int GL_COLOR_ATTACHMENT6 = 0x8ce6;
    public static final int GL_COLOR_ATTACHMENT7 = 0x8ce7;
    public static final int GL_COLOR_ATTACHMENT8 = 0x8ce8;
    public static final int GL_COLOR_ATTACHMENT9 = 0x8ce9;
    public static final int GL_COLOR_BUFFER_BIT = 0x4000;
    public static final int GL_COLOR_CLEAR_VALUE = 0xc22;
    public static final int GL_COLOR_COMPONENTS = 0x8283;
    public static final int GL_COLOR_ENCODING = 0x8296;
    public static final int GL_COLOR_INDEX = 0x1900;
    public static final int GL_COLOR_INDEX12_EXT = 0x80e6;
    public static final int GL_COLOR_INDEX16_EXT = 0x80e7;
    public static final int GL_COLOR_INDEX1_EXT = 0x80e2;
    public static final int GL_COLOR_INDEX2_EXT = 0x80e3;
    public static final int GL_COLOR_INDEX4_EXT = 0x80e4;
    public static final int GL_COLOR_INDEX8_EXT = 0x80e5;
    public static final int GL_COLOR_INDEXES = 0x1603;
    public static final int GL_COLOR_LOGIC_OP = 0xbf2;
    public static final int GL_COLOR_MATERIAL = 0xb57;
    public static final int GL_COLOR_MATERIAL_FACE = 0xb55;
    public static final int GL_COLOR_MATERIAL_PARAMETER = 0xb56;
    public static final int GL_COLOR_RENDERABLE = 0x8286;
    public static final int GL_COLOR_TABLE_ALPHA_SIZE_EXT = 0x80dd;
    public static final int GL_COLOR_TABLE_BLUE_SIZE_EXT = 0x80dc;
    public static final int GL_COLOR_TABLE_FORMAT_EXT = 0x80d8;
    public static final int GL_COLOR_TABLE_GREEN_SIZE_EXT = 0x80db;
    public static final int GL_COLOR_TABLE_INTENSITY_SIZE_EXT = 0x80df;
    public static final int GL_COLOR_TABLE_LUMINANCE_SIZE_EXT = 0x80de;
    public static final int GL_COLOR_TABLE_RED_SIZE_EXT = 0x80da;
    public static final int GL_COLOR_TABLE_WIDTH_EXT = 0x80d9;
    public static final int GL_COLOR_WRITEMASK = 0xc23;
    public static final int GL_COMMAND_BARRIER_BIT = 0x40;
    public static final int GL_COMPARE_REF_TO_TEXTURE = 0x884e;
    public static final int GL_COMPATIBLE_SUBROUTINES = 0x8e4b;
    public static final int GL_COMPILE = 0x1300;
    public static final int GL_COMPILE_AND_EXECUTE = 0x1301;
    public static final int GL_COMPILE_STATUS = 0x8b81;
    public static final int GL_COMPRESSED_R11_EAC = 0x9270;
    public static final int GL_COMPRESSED_RED = 0x8225;
    public static final int GL_COMPRESSED_RED_RGTC1 = 0x8dbb;
    public static final int GL_COMPRESSED_RG = 0x8226;
    public static final int GL_COMPRESSED_RG11_EAC = 0x9272;
    public static final int GL_COMPRESSED_RGB = 0x84ed;
    public static final int GL_COMPRESSED_RGB8_ETC2 = 0x9274;
    public static final int GL_COMPRESSED_RGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9276;
    public static final int GL_COMPRESSED_RGBA = 0x84ee;
    public static final int GL_COMPRESSED_RGBA8_ETC2_EAC = 0x9278;
    public static final int GL_COMPRESSED_RGBA_BPTC_UNORM = 0x8e8c;
    public static final int GL_COMPRESSED_RGBA_BPTC_UNORM_ARB = 0x8e8c;
    public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT = 0x8e8e;
    public static final int GL_COMPRESSED_RGB_BPTC_SIGNED_FLOAT_ARB = 0x8e8e;
    public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT = 0x8e8f;
    public static final int GL_COMPRESSED_RGB_BPTC_UNSIGNED_FLOAT_ARB = 0x8e8f;
    public static final int GL_COMPRESSED_RG_RGTC2 = 0x8dbd;
    public static final int GL_COMPRESSED_SIGNED_R11_EAC = 0x9271;
    public static final int GL_COMPRESSED_SIGNED_RED_RGTC1 = 0x8dbc;
    public static final int GL_COMPRESSED_SIGNED_RG11_EAC = 0x9273;
    public static final int GL_COMPRESSED_SIGNED_RG_RGTC2 = 0x8dbe;
    public static final int GL_COMPRESSED_SRGB = 0x8c48;
    public static final int GL_COMPRESSED_SRGB8_ALPHA8_ETC2_EAC = 0x9279;
    public static final int GL_COMPRESSED_SRGB8_ETC2 = 0x9275;
    public static final int GL_COMPRESSED_SRGB8_PUNCHTHROUGH_ALPHA1_ETC2 = 0x9277;
    public static final int GL_COMPRESSED_SRGB_ALPHA = 0x8c49;
    public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM = 0x8e8d;
    public static final int GL_COMPRESSED_SRGB_ALPHA_BPTC_UNORM_ARB = 0x8e8d;
    public static final int GL_COMPRESSED_TEXTURE_FORMATS = 0x86a3;
    public static final int GL_COMPUTE_SHADER = 0x91b9;
    public static final int GL_COMPUTE_SHADER_BIT = 0x20;
    public static final int GL_COMPUTE_SHADER_INVOCATIONS_ARB = 0x82f5;
    public static final int GL_COMPUTE_SUBROUTINE = 0x92ed;
    public static final int GL_COMPUTE_SUBROUTINE_UNIFORM = 0x92f3;
    public static final int GL_COMPUTE_TEXTURE = 0x82a0;
    public static final int GL_COMPUTE_WORK_GROUP_SIZE = 0x8267;
    public static final int GL_CONDITION_SATISFIED = 0x911c;
    public static final int GL_CONSTANT_ALPHA = 0x8003;
    public static final int GL_CONSTANT_ATTENUATION = 0x1207;
    public static final int GL_CONSTANT_COLOR = 0x8001;
    public static final int GL_CONTEXT_COMPATIBILITY_PROFILE_BIT = 0x2;
    public static final int GL_CONTEXT_CORE_PROFILE_BIT = 0x1;
    public static final int GL_CONTEXT_FLAGS = 0x821e;
    public static final int GL_CONTEXT_FLAG_DEBUG_BIT = 0x2;
    public static final int GL_CONTEXT_FLAG_FORWARD_COMPATIBLE_BIT = 0x1;
    public static final int GL_CONTEXT_FLAG_NO_ERROR_BIT_KHR = 0x8;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT = 0x4;
    public static final int GL_CONTEXT_FLAG_ROBUST_ACCESS_BIT_ARB = 0x4;
    public static final int GL_CONTEXT_LOST = 0x507;
    public static final int GL_CONTEXT_PROFILE_MASK = 0x9126;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR = 0x82fb;
    public static final int GL_CONTEXT_RELEASE_BEHAVIOR_FLUSH = 0x82fc;
    public static final int GL_CONTEXT_ROBUST_ACCESS = 0x90f3;
    public static final int GL_COPY = 0x1503;
    public static final int GL_COPY_INVERTED = 0x150c;
    public static final int GL_COPY_PIXEL_TOKEN = 0x706;
    public static final int GL_COPY_READ_BUFFER = 0x8f36;
    public static final int GL_COPY_READ_BUFFER_BINDING = 0x8f36;
    public static final int GL_COPY_WRITE_BUFFER = 0x8f37;
    public static final int GL_COPY_WRITE_BUFFER_BINDING = 0x8f37;
    public static final int GL_CULL_FACE = 0xb44;
    public static final int GL_CULL_FACE_MODE = 0xb45;
    public static final int GL_CURRENT_BIT = 0x1;
    public static final int GL_CURRENT_COLOR = 0xb00;
    public static final int GL_CURRENT_INDEX = 0xb01;
    public static final int GL_CURRENT_NORMAL = 0xb02;
    public static final int GL_CURRENT_PROGRAM = 0x8b8d;
    public static final int GL_CURRENT_QUERY = 0x8865;
    public static final int GL_CURRENT_RASTER_COLOR = 0xb04;
    public static final int GL_CURRENT_RASTER_DISTANCE = 0xb09;
    public static final int GL_CURRENT_RASTER_INDEX = 0xb05;
    public static final int GL_CURRENT_RASTER_POSITION = 0xb07;
    public static final int GL_CURRENT_RASTER_POSITION_VALID = 0xb08;
    public static final int GL_CURRENT_RASTER_TEXTURE_COORDS = 0xb06;
    public static final int GL_CURRENT_TEXTURE_COORDS = 0xb03;
    public static final int GL_CURRENT_VERTEX_ATTRIB = 0x8626;
    public static final int GL_CW = 0x900;
    public static final int GL_DEBUG_CALLBACK_FUNCTION = 0x8244;
    public static final int GL_DEBUG_CALLBACK_FUNCTION_ARB = 0x8244;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM = 0x8245;
    public static final int GL_DEBUG_CALLBACK_USER_PARAM_ARB = 0x8245;
    public static final int GL_DEBUG_GROUP_STACK_DEPTH = 0x826d;
    public static final int GL_DEBUG_LOGGED_MESSAGES = 0x9145;
    public static final int GL_DEBUG_LOGGED_MESSAGES_ARB = 0x9145;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH = 0x8243;
    public static final int GL_DEBUG_NEXT_LOGGED_MESSAGE_LENGTH_ARB = 0x8243;
    public static final int GL_DEBUG_OUTPUT = 0x92e0;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS = 0x8242;
    public static final int GL_DEBUG_OUTPUT_SYNCHRONOUS_ARB = 0x8242;
    public static final int GL_DEBUG_SEVERITY_HIGH = 0x9146;
    public static final int GL_DEBUG_SEVERITY_HIGH_ARB = 0x9146;
    public static final int GL_DEBUG_SEVERITY_LOW = 0x9148;
    public static final int GL_DEBUG_SEVERITY_LOW_ARB = 0x9148;
    public static final int GL_DEBUG_SEVERITY_MEDIUM = 0x9147;
    public static final int GL_DEBUG_SEVERITY_MEDIUM_ARB = 0x9147;
    public static final int GL_DEBUG_SEVERITY_NOTIFICATION = 0x826b;
    public static final int GL_DEBUG_SOURCE_API = 0x8246;
    public static final int GL_DEBUG_SOURCE_API_ARB = 0x8246;
    public static final int GL_DEBUG_SOURCE_APPLICATION = 0x824a;
    public static final int GL_DEBUG_SOURCE_APPLICATION_ARB = 0x824a;
    public static final int GL_DEBUG_SOURCE_OTHER = 0x824b;
    public static final int GL_DEBUG_SOURCE_OTHER_ARB = 0x824b;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER = 0x8248;
    public static final int GL_DEBUG_SOURCE_SHADER_COMPILER_ARB = 0x8248;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY = 0x8249;
    public static final int GL_DEBUG_SOURCE_THIRD_PARTY_ARB = 0x8249;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM = 0x8247;
    public static final int GL_DEBUG_SOURCE_WINDOW_SYSTEM_ARB = 0x8247;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR = 0x824d;
    public static final int GL_DEBUG_TYPE_DEPRECATED_BEHAVIOR_ARB = 0x824d;
    public static final int GL_DEBUG_TYPE_ERROR = 0x824c;
    public static final int GL_DEBUG_TYPE_ERROR_ARB = 0x824c;
    public static final int GL_DEBUG_TYPE_MARKER = 0x8268;
    public static final int GL_DEBUG_TYPE_OTHER = 0x8251;
    public static final int GL_DEBUG_TYPE_OTHER_ARB = 0x8251;
    public static final int GL_DEBUG_TYPE_PERFORMANCE = 0x8250;
    public static final int GL_DEBUG_TYPE_PERFORMANCE_ARB = 0x8250;
    public static final int GL_DEBUG_TYPE_POP_GROUP = 0x826a;
    public static final int GL_DEBUG_TYPE_PORTABILITY = 0x824f;
    public static final int GL_DEBUG_TYPE_PORTABILITY_ARB = 0x824f;
    public static final int GL_DEBUG_TYPE_PUSH_GROUP = 0x8269;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR = 0x824e;
    public static final int GL_DEBUG_TYPE_UNDEFINED_BEHAVIOR_ARB = 0x824e;
    public static final int GL_DECAL = 0x2101;
    public static final int GL_DECR = 0x1e03;
    public static final int GL_DECR_WRAP = 0x8508;
    public static final int GL_DELETE_STATUS = 0x8b80;
    public static final int GL_DEPTH = 0x1801;
    public static final int GL_DEPTH24_STENCIL8 = 0x88f0;
    public static final int GL_DEPTH32F_STENCIL8 = 0x8cad;
    public static final int GL_DEPTH_ATTACHMENT = 0x8d00;
    public static final int GL_DEPTH_BIAS = 0xd1f;
    public static final int GL_DEPTH_BITS = 0xd56;
    public static final int GL_DEPTH_BUFFER_BIT = 0x100;
    public static final int GL_DEPTH_CLAMP = 0x864f;
    public static final int GL_DEPTH_CLEAR_VALUE = 0xb73;
    public static final int GL_DEPTH_COMPONENT = 0x1902;
    public static final int GL_DEPTH_COMPONENT16 = 0x81a5;
    public static final int GL_DEPTH_COMPONENT24 = 0x81a6;
    public static final int GL_DEPTH_COMPONENT32 = 0x81a7;
    public static final int GL_DEPTH_COMPONENT32F = 0x8cac;
    public static final int GL_DEPTH_COMPONENTS = 0x8284;
    public static final int GL_DEPTH_FUNC = 0xb74;
    public static final int GL_DEPTH_RANGE = 0xb70;
    public static final int GL_DEPTH_RENDERABLE = 0x8287;
    public static final int GL_DEPTH_SCALE = 0xd1e;
    public static final int GL_DEPTH_STENCIL = 0x84f9;
    public static final int GL_DEPTH_STENCIL_ATTACHMENT = 0x821a;
    public static final int GL_DEPTH_STENCIL_TEXTURE_MODE = 0x90ea;
    public static final int GL_DEPTH_TEST = 0xb71;
    public static final int GL_DEPTH_WRITEMASK = 0xb72;
    public static final int GL_DIFFUSE = 0x1201;
    public static final int GL_DISPATCH_INDIRECT_BUFFER = 0x90ee;
    public static final int GL_DISPATCH_INDIRECT_BUFFER_BINDING = 0x90ef;
    public static final int GL_DITHER = 0xbd0;
    public static final int GL_DOMAIN = 0xa02;
    public static final int GL_DONT_CARE = 0x1100;
    public static final int GL_DOUBLE = 0x140a;
    public static final int GL_DOUBLEBUFFER = 0xc32;
    public static final int GL_DOUBLE_MAT2 = 0x8f46;
    public static final int GL_DOUBLE_MAT3 = 0x8f47;
    public static final int GL_DOUBLE_MAT4 = 0x8f48;
    public static final int GL_DOUBLE_VEC2 = 0x8ffc;
    public static final int GL_DOUBLE_VEC3 = 0x8ffd;
    public static final int GL_DOUBLE_VEC4 = 0x8ffe;
    public static final int GL_DRAW_BUFFER = 0xc01;
    public static final int GL_DRAW_BUFFER0 = 0x8825;
    public static final int GL_DRAW_BUFFER1 = 0x8826;
    public static final int GL_DRAW_BUFFER10 = 0x882f;
    public static final int GL_DRAW_BUFFER11 = 0x8830;
    public static final int GL_DRAW_BUFFER12 = 0x8831;
    public static final int GL_DRAW_BUFFER13 = 0x8832;
    public static final int GL_DRAW_BUFFER14 = 0x8833;
    public static final int GL_DRAW_BUFFER15 = 0x8834;
    public static final int GL_DRAW_BUFFER2 = 0x8827;
    public static final int GL_DRAW_BUFFER3 = 0x8828;
    public static final int GL_DRAW_BUFFER4 = 0x8829;
    public static final int GL_DRAW_BUFFER5 = 0x882a;
    public static final int GL_DRAW_BUFFER6 = 0x882b;
    public static final int GL_DRAW_BUFFER7 = 0x882c;
    public static final int GL_DRAW_BUFFER8 = 0x882d;
    public static final int GL_DRAW_BUFFER9 = 0x882e;
    public static final int GL_DRAW_FRAMEBUFFER = 0x8ca9;
    public static final int GL_DRAW_FRAMEBUFFER_BINDING = 0x8ca6;
    public static final int GL_DRAW_INDIRECT_BUFFER = 0x8f3f;
    public static final int GL_DRAW_INDIRECT_BUFFER_BINDING = 0x8f43;
    public static final int GL_DRAW_PIXEL_TOKEN = 0x705;
    public static final int GL_DST_ALPHA = 0x304;
    public static final int GL_DST_COLOR = 0x306;
    public static final int GL_DYNAMIC_COPY = 0x88ea;
    public static final int GL_DYNAMIC_DRAW = 0x88e8;
    public static final int GL_DYNAMIC_READ = 0x88e9;
    public static final int GL_DYNAMIC_STORAGE_BIT = 0x100;
    public static final int GL_EDGE_FLAG = 0xb43;
    public static final int GL_EDGE_FLAG_ARRAY = 0x8079;
    public static final int GL_EDGE_FLAG_ARRAY_COUNT_EXT = 0x808d;
    public static final int GL_EDGE_FLAG_ARRAY_EXT = 0x8079;
    public static final int GL_EDGE_FLAG_ARRAY_POINTER = 0x8093;
    public static final int GL_EDGE_FLAG_ARRAY_POINTER_EXT = 0x8093;
    public static final int GL_EDGE_FLAG_ARRAY_STRIDE = 0x808c;
    public static final int GL_EDGE_FLAG_ARRAY_STRIDE_EXT = 0x808c;
    public static final int GL_ELEMENT_ARRAY_BARRIER_BIT = 0x2;
    public static final int GL_ELEMENT_ARRAY_BUFFER = 0x8893;
    public static final int GL_ELEMENT_ARRAY_BUFFER_BINDING = 0x8895;
    public static final int GL_EMISSION = 0x1600;
    public static final int GL_ENABLE_BIT = 0x2000;
    public static final int GL_EQUAL = 0x202;
    public static final int GL_EQUIV = 0x1509;
    public static final int GL_EVAL_BIT = 0x10000;
    public static final int GL_EXP = 0x800;
    public static final int GL_EXP2 = 0x801;
    public static final int GL_EXTENSIONS = 0x1f03;
    public static final int GL_EYE_LINEAR = 0x2400;
    public static final int GL_EYE_PLANE = 0x2502;
    public static final int GL_FALSE = 0x0;
    public static final int GL_FASTEST = 0x1101;
    public static final int GL_FEEDBACK = 0x1c01;
    public static final int GL_FEEDBACK_BUFFER_POINTER = 0xdf0;
    public static final int GL_FEEDBACK_BUFFER_SIZE = 0xdf1;
    public static final int GL_FEEDBACK_BUFFER_TYPE = 0xdf2;
    public static final int GL_FILL = 0x1b02;
    public static final int GL_FILTER = 0x829a;
    public static final int GL_FIRST_VERTEX_CONVENTION = 0x8e4d;
    public static final int GL_FIXED = 0x140c;
    public static final int GL_FIXED_ONLY = 0x891d;
    public static final int GL_FLAT = 0x1d00;
    public static final int GL_FLOAT = 0x1406;
    public static final int GL_FLOAT_32_UNSIGNED_INT_24_8_REV = 0x8dad;
    public static final int GL_FLOAT_MAT2 = 0x8b5a;
    public static final int GL_FLOAT_MAT3 = 0x8b5b;
    public static final int GL_FLOAT_MAT4 = 0x8b5c;
    public static final int GL_FLOAT_VEC2 = 0x8b50;
    public static final int GL_FLOAT_VEC3 = 0x8b51;
    public static final int GL_FLOAT_VEC4 = 0x8b52;
    public static final int GL_FOG = 0xb60;
    public static final int GL_FOG_BIT = 0x80;
    public static final int GL_FOG_COLOR = 0xb66;
    public static final int GL_FOG_DENSITY = 0xb62;
    public static final int GL_FOG_END = 0xb64;
    public static final int GL_FOG_HINT = 0xc54;
    public static final int GL_FOG_INDEX = 0xb61;
    public static final int GL_FOG_MODE = 0xb65;
    public static final int GL_FOG_SPECULAR_TEXTURE_WIN = 0x80ec;
    public static final int GL_FOG_START = 0xb63;
    public static final int GL_FRACTIONAL_EVEN = 0x8e7c;
    public static final int GL_FRACTIONAL_ODD = 0x8e7b;
    public static final int GL_FRAGMENT_INTERPOLATION_OFFSET_BITS = 0x8e5d;
    public static final int GL_FRAGMENT_SHADER = 0x8b30;
    public static final int GL_FRAGMENT_SHADER_BIT = 0x2;
    public static final int GL_FRAGMENT_SHADER_DERIVATIVE_HINT = 0x8b8b;
    public static final int GL_FRAGMENT_SHADER_INVOCATIONS_ARB = 0x82f4;
    public static final int GL_FRAGMENT_SUBROUTINE = 0x92ec;
    public static final int GL_FRAGMENT_SUBROUTINE_UNIFORM = 0x92f2;
    public static final int GL_FRAGMENT_TEXTURE = 0x829f;
    public static final int GL_FRAMEBUFFER = 0x8d40;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_ALPHA_SIZE = 0x8215;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_BLUE_SIZE = 0x8214;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COLOR_ENCODING = 0x8210;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_COMPONENT_TYPE = 0x8211;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_DEPTH_SIZE = 0x8216;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_GREEN_SIZE = 0x8213;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_LAYERED = 0x8da7;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_NAME = 0x8cd1;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_OBJECT_TYPE = 0x8cd0;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_RED_SIZE = 0x8212;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_STENCIL_SIZE = 0x8217;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_CUBE_MAP_FACE = 0x8cd3;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LAYER = 0x8cd4;
    public static final int GL_FRAMEBUFFER_ATTACHMENT_TEXTURE_LEVEL = 0x8cd2;
    public static final int GL_FRAMEBUFFER_BARRIER_BIT = 0x400;
    public static final int GL_FRAMEBUFFER_BINDING = 0x8ca6;
    public static final int GL_FRAMEBUFFER_BLEND = 0x828b;
    public static final int GL_FRAMEBUFFER_COMPLETE = 0x8cd5;
    public static final int GL_FRAMEBUFFER_DEFAULT = 0x8218;
    public static final int GL_FRAMEBUFFER_DEFAULT_FIXED_SAMPLE_LOCATIONS = 0x9314;
    public static final int GL_FRAMEBUFFER_DEFAULT_HEIGHT = 0x9311;
    public static final int GL_FRAMEBUFFER_DEFAULT_LAYERS = 0x9312;
    public static final int GL_FRAMEBUFFER_DEFAULT_SAMPLES = 0x9313;
    public static final int GL_FRAMEBUFFER_DEFAULT_WIDTH = 0x9310;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_ATTACHMENT = 0x8cd6;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_DRAW_BUFFER = 0x8cdb;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_LAYER_TARGETS = 0x8da8;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MISSING_ATTACHMENT = 0x8cd7;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_MULTISAMPLE = 0x8d56;
    public static final int GL_FRAMEBUFFER_INCOMPLETE_READ_BUFFER = 0x8cdc;
    public static final int GL_FRAMEBUFFER_RENDERABLE = 0x8289;
    public static final int GL_FRAMEBUFFER_RENDERABLE_LAYERED = 0x828a;
    public static final int GL_FRAMEBUFFER_SRGB = 0x8db9;
    public static final int GL_FRAMEBUFFER_UNDEFINED = 0x8219;
    public static final int GL_FRAMEBUFFER_UNSUPPORTED = 0x8cdd;
    public static final int GL_FRONT = 0x404;
    public static final int GL_FRONT_AND_BACK = 0x408;
    public static final int GL_FRONT_FACE = 0xb46;
    public static final int GL_FRONT_LEFT = 0x400;
    public static final int GL_FRONT_RIGHT = 0x401;
    public static final int GL_FULL_SUPPORT = 0x82b7;
    public static final int GL_FUNC_ADD = 0x8006;
    public static final int GL_FUNC_REVERSE_SUBTRACT = 0x800b;
    public static final int GL_FUNC_SUBTRACT = 0x800a;
    public static final int GL_GEOMETRY_INPUT_TYPE = 0x8917;
    public static final int GL_GEOMETRY_OUTPUT_TYPE = 0x8918;
    public static final int GL_GEOMETRY_SHADER = 0x8dd9;
    public static final int GL_GEOMETRY_SHADER_BIT = 0x4;
    public static final int GL_GEOMETRY_SHADER_INVOCATIONS = 0x887f;
    public static final int GL_GEOMETRY_SHADER_PRIMITIVES_EMITTED_ARB = 0x82f3;
    public static final int GL_GEOMETRY_SUBROUTINE = 0x92eb;
    public static final int GL_GEOMETRY_SUBROUTINE_UNIFORM = 0x92f1;
    public static final int GL_GEOMETRY_TEXTURE = 0x829e;
    public static final int GL_GEOMETRY_VERTICES_OUT = 0x8916;
    public static final int GL_GEQUAL = 0x206;
    public static final int GL_GET_TEXTURE_IMAGE_FORMAT = 0x8291;
    public static final int GL_GET_TEXTURE_IMAGE_TYPE = 0x8292;
    public static final int GL_GREATER = 0x204;
    public static final int GL_GREEN = 0x1904;
    public static final int GL_GREEN_BIAS = 0xd19;
    public static final int GL_GREEN_BITS = 0xd53;
    public static final int GL_GREEN_INTEGER = 0x8d95;
    public static final int GL_GREEN_SCALE = 0xd18;
    public static final int GL_GUILTY_CONTEXT_RESET = 0x8253;
    public static final int GL_GUILTY_CONTEXT_RESET_ARB = 0x8253;
    public static final int GL_HALF_FLOAT = 0x140b;
    public static final int GL_HIGH_FLOAT = 0x8df2;
    public static final int GL_HIGH_INT = 0x8df5;
    public static final int GL_HINT_BIT = 0x8000;
    public static final int GL_IMAGE_1D = 0x904c;
    public static final int GL_IMAGE_1D_ARRAY = 0x9052;
    public static final int GL_IMAGE_2D = 0x904d;
    public static final int GL_IMAGE_2D_ARRAY = 0x9053;
    public static final int GL_IMAGE_2D_MULTISAMPLE = 0x9055;
    public static final int GL_IMAGE_2D_MULTISAMPLE_ARRAY = 0x9056;
    public static final int GL_IMAGE_2D_RECT = 0x904f;
    public static final int GL_IMAGE_3D = 0x904e;
    public static final int GL_IMAGE_BINDING_ACCESS = 0x8f3e;
    public static final int GL_IMAGE_BINDING_FORMAT = 0x906e;
    public static final int GL_IMAGE_BINDING_LAYER = 0x8f3d;
    public static final int GL_IMAGE_BINDING_LAYERED = 0x8f3c;
    public static final int GL_IMAGE_BINDING_LEVEL = 0x8f3b;
    public static final int GL_IMAGE_BINDING_NAME = 0x8f3a;
    public static final int GL_IMAGE_BUFFER = 0x9051;
    public static final int GL_IMAGE_CLASS_10_10_10_2 = 0x82c3;
    public static final int GL_IMAGE_CLASS_11_11_10 = 0x82c2;
    public static final int GL_IMAGE_CLASS_1_X_16 = 0x82be;
    public static final int GL_IMAGE_CLASS_1_X_32 = 0x82bb;
    public static final int GL_IMAGE_CLASS_1_X_8 = 0x82c1;
    public static final int GL_IMAGE_CLASS_2_X_16 = 0x82bd;
    public static final int GL_IMAGE_CLASS_2_X_32 = 0x82ba;
    public static final int GL_IMAGE_CLASS_2_X_8 = 0x82c0;
    public static final int GL_IMAGE_CLASS_4_X_16 = 0x82bc;
    public static final int GL_IMAGE_CLASS_4_X_32 = 0x82b9;
    public static final int GL_IMAGE_CLASS_4_X_8 = 0x82bf;
    public static final int GL_IMAGE_COMPATIBILITY_CLASS = 0x82a8;
    public static final int GL_IMAGE_CUBE = 0x9050;
    public static final int GL_IMAGE_CUBE_MAP_ARRAY = 0x9054;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_CLASS = 0x90c9;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_BY_SIZE = 0x90c8;
    public static final int GL_IMAGE_FORMAT_COMPATIBILITY_TYPE = 0x90c7;
    public static final int GL_IMAGE_PIXEL_FORMAT = 0x82a9;
    public static final int GL_IMAGE_PIXEL_TYPE = 0x82aa;
    public static final int GL_IMAGE_TEXEL_SIZE = 0x82a7;
    public static final int GL_IMPLEMENTATION_COLOR_READ_FORMAT = 0x8b9b;
    public static final int GL_IMPLEMENTATION_COLOR_READ_TYPE = 0x8b9a;
    public static final int GL_INCR = 0x1e02;
    public static final int GL_INCR_WRAP = 0x8507;
    public static final int GL_INDEX_ARRAY = 0x8077;
    public static final int GL_INDEX_ARRAY_COUNT_EXT = 0x8087;
    public static final int GL_INDEX_ARRAY_EXT = 0x8077;
    public static final int GL_INDEX_ARRAY_POINTER = 0x8091;
    public static final int GL_INDEX_ARRAY_POINTER_EXT = 0x8091;
    public static final int GL_INDEX_ARRAY_STRIDE = 0x8086;
    public static final int GL_INDEX_ARRAY_STRIDE_EXT = 0x8086;
    public static final int GL_INDEX_ARRAY_TYPE = 0x8085;
    public static final int GL_INDEX_ARRAY_TYPE_EXT = 0x8085;
    public static final int GL_INDEX_BITS = 0xd51;
    public static final int GL_INDEX_CLEAR_VALUE = 0xc20;
    public static final int GL_INDEX_LOGIC_OP = 0xbf1;
    public static final int GL_INDEX_MODE = 0xc30;
    public static final int GL_INDEX_OFFSET = 0xd13;
    public static final int GL_INDEX_SHIFT = 0xd12;
    public static final int GL_INDEX_WRITEMASK = 0xc21;
    public static final int GL_INFO_LOG_LENGTH = 0x8b84;
    public static final int GL_INNOCENT_CONTEXT_RESET = 0x8254;
    public static final int GL_INNOCENT_CONTEXT_RESET_ARB = 0x8254;
    public static final int GL_INTENSITY = 0x8049;
    public static final int GL_INTENSITY12 = 0x804c;
    public static final int GL_INTENSITY16 = 0x804d;
    public static final int GL_INTENSITY4 = 0x804a;
    public static final int GL_INTENSITY8 = 0x804b;
    public static final int GL_INTERLEAVED_ATTRIBS = 0x8c8c;
    public static final int GL_INTERNALFORMAT_ALPHA_SIZE = 0x8274;
    public static final int GL_INTERNALFORMAT_ALPHA_TYPE = 0x827b;
    public static final int GL_INTERNALFORMAT_BLUE_SIZE = 0x8273;
    public static final int GL_INTERNALFORMAT_BLUE_TYPE = 0x827a;
    public static final int GL_INTERNALFORMAT_DEPTH_SIZE = 0x8275;
    public static final int GL_INTERNALFORMAT_DEPTH_TYPE = 0x827c;
    public static final int GL_INTERNALFORMAT_GREEN_SIZE = 0x8272;
    public static final int GL_INTERNALFORMAT_GREEN_TYPE = 0x8279;
    public static final int GL_INTERNALFORMAT_PREFERRED = 0x8270;
    public static final int GL_INTERNALFORMAT_RED_SIZE = 0x8271;
    public static final int GL_INTERNALFORMAT_RED_TYPE = 0x8278;
    public static final int GL_INTERNALFORMAT_SHARED_SIZE = 0x8277;
    public static final int GL_INTERNALFORMAT_STENCIL_SIZE = 0x8276;
    public static final int GL_INTERNALFORMAT_STENCIL_TYPE = 0x827d;
    public static final int GL_INTERNALFORMAT_SUPPORTED = 0x826f;
    public static final int GL_INT_2_10_10_10_REV = 0x8d9f;
    public static final int GL_INT_IMAGE_1D = 0x9057;
    public static final int GL_INT_IMAGE_1D_ARRAY = 0x905d;
    public static final int GL_INT_IMAGE_2D = 0x9058;
    public static final int GL_INT_IMAGE_2D_ARRAY = 0x905e;
    public static final int GL_INT_IMAGE_2D_MULTISAMPLE = 0x9060;
    public static final int GL_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 0x9061;
    public static final int GL_INT_IMAGE_2D_RECT = 0x905a;
    public static final int GL_INT_IMAGE_3D = 0x9059;
    public static final int GL_INT_IMAGE_BUFFER = 0x905c;
    public static final int GL_INT_IMAGE_CUBE = 0x905b;
    public static final int GL_INT_IMAGE_CUBE_MAP_ARRAY = 0x905f;
    public static final int GL_INT_SAMPLER_1D = 0x8dc9;
    public static final int GL_INT_SAMPLER_1D_ARRAY = 0x8dce;
    public static final int GL_INT_SAMPLER_2D = 0x8dca;
    public static final int GL_INT_SAMPLER_2D_ARRAY = 0x8dcf;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE = 0x9109;
    public static final int GL_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910c;
    public static final int GL_INT_SAMPLER_2D_RECT = 0x8dcd;
    public static final int GL_INT_SAMPLER_3D = 0x8dcb;
    public static final int GL_INT_SAMPLER_BUFFER = 0x8dd0;
    public static final int GL_INT_SAMPLER_CUBE = 0x8dcc;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY = 0x900e;
    public static final int GL_INT_SAMPLER_CUBE_MAP_ARRAY_ARB = 0x900e;
    public static final int GL_INT_VEC2 = 0x8b53;
    public static final int GL_INT_VEC3 = 0x8b54;
    public static final int GL_INT_VEC4 = 0x8b55;
    public static final int GL_INVALID_ENUM = 0x500;
    public static final int GL_INVALID_FRAMEBUFFER_OPERATION = 0x506;
    public static final int GL_INVALID_OPERATION = 0x502;
    public static final int GL_INVALID_VALUE = 0x501;
    public static final int GL_INVERT = 0x150a;
    public static final int GL_ISOLINES = 0x8e7a;
    public static final int GL_IS_PER_PATCH = 0x92e7;
    public static final int GL_IS_ROW_MAJOR = 0x9300;
    public static final int GL_KEEP = 0x1e00;
    public static final int GL_LAST_VERTEX_CONVENTION = 0x8e4e;
    public static final int GL_LAYER_PROVOKING_VERTEX = 0x825e;
    public static final int GL_LEFT = 0x406;
    public static final int GL_LEQUAL = 0x203;
    public static final int GL_LESS = 0x201;
    public static final int GL_LIGHT0 = 0x4000;
    public static final int GL_LIGHT1 = 0x4001;
    public static final int GL_LIGHT2 = 0x4002;
    public static final int GL_LIGHT3 = 0x4003;
    public static final int GL_LIGHT4 = 0x4004;
    public static final int GL_LIGHT5 = 0x4005;
    public static final int GL_LIGHT6 = 0x4006;
    public static final int GL_LIGHT7 = 0x4007;
    public static final int GL_LIGHTING = 0xb50;
    public static final int GL_LIGHTING_BIT = 0x40;
    public static final int GL_LIGHT_MODEL_AMBIENT = 0xb53;
    public static final int GL_LIGHT_MODEL_LOCAL_VIEWER = 0xb51;
    public static final int GL_LIGHT_MODEL_TWO_SIDE = 0xb52;
    public static final int GL_LINE = 0x1b01;
    public static final int GL_LINEAR = 0x2601;
    public static final int GL_LINEAR_ATTENUATION = 0x1208;
    public static final int GL_LINEAR_MIPMAP_LINEAR = 0x2703;
    public static final int GL_LINEAR_MIPMAP_NEAREST = 0x2701;
    public static final int GL_LINES = 0x1;
    public static final int GL_LINES_ADJACENCY = 0xa;
    public static final int GL_LINE_BIT = 0x4;
    public static final int GL_LINE_LOOP = 0x2;
    public static final int GL_LINE_RESET_TOKEN = 0x707;
    public static final int GL_LINE_SMOOTH = 0xb20;
    public static final int GL_LINE_SMOOTH_HINT = 0xc52;
    public static final int GL_LINE_STIPPLE = 0xb24;
    public static final int GL_LINE_STIPPLE_PATTERN = 0xb25;
    public static final int GL_LINE_STIPPLE_REPEAT = 0xb26;
    public static final int GL_LINE_STRIP = 0x3;
    public static final int GL_LINE_STRIP_ADJACENCY = 0xb;
    public static final int GL_LINE_TOKEN = 0x702;
    public static final int GL_LINE_WIDTH = 0xb21;
    public static final int GL_LINE_WIDTH_GRANULARITY = 0xb23;
    public static final int GL_LINE_WIDTH_RANGE = 0xb22;
    public static final int GL_LINK_STATUS = 0x8b82;
    public static final int GL_LIST_BASE = 0xb32;
    public static final int GL_LIST_BIT = 0x20000;
    public static final int GL_LIST_INDEX = 0xb33;
    public static final int GL_LIST_MODE = 0xb30;
    public static final int GL_LOAD = 0x101;
    public static final int GL_LOCATION = 0x930e;
    public static final int GL_LOCATION_COMPONENT = 0x934a;
    public static final int GL_LOCATION_INDEX = 0x930f;
    public static final int GL_LOGIC_OP_MODE = 0xbf0;
    public static final int GL_LOSE_CONTEXT_ON_RESET = 0x8252;
    public static final int GL_LOSE_CONTEXT_ON_RESET_ARB = 0x8252;
    public static final int GL_LOWER_LEFT = 0x8ca1;
    public static final int GL_LOW_FLOAT = 0x8df0;
    public static final int GL_LOW_INT = 0x8df3;
    public static final int GL_LUMINANCE = 0x1909;
    public static final int GL_LUMINANCE12 = 0x8041;
    public static final int GL_LUMINANCE12_ALPHA12 = 0x8047;
    public static final int GL_LUMINANCE12_ALPHA4 = 0x8046;
    public static final int GL_LUMINANCE16 = 0x8042;
    public static final int GL_LUMINANCE16_ALPHA16 = 0x8048;
    public static final int GL_LUMINANCE4 = 0x803f;
    public static final int GL_LUMINANCE4_ALPHA4 = 0x8043;
    public static final int GL_LUMINANCE6_ALPHA2 = 0x8044;
    public static final int GL_LUMINANCE8 = 0x8040;
    public static final int GL_LUMINANCE8_ALPHA8 = 0x8045;
    public static final int GL_LUMINANCE_ALPHA = 0x190a;
    public static final int GL_MAJOR_VERSION = 0x821b;
    public static final int GL_MANUAL_GENERATE_MIPMAP = 0x8294;
    public static final int GL_MAP1_COLOR_4 = 0xd90;
    public static final int GL_MAP1_GRID_DOMAIN = 0xdd0;
    public static final int GL_MAP1_GRID_SEGMENTS = 0xdd1;
    public static final int GL_MAP1_INDEX = 0xd91;
    public static final int GL_MAP1_NORMAL = 0xd92;
    public static final int GL_MAP1_TEXTURE_COORD_1 = 0xd93;
    public static final int GL_MAP1_TEXTURE_COORD_2 = 0xd94;
    public static final int GL_MAP1_TEXTURE_COORD_3 = 0xd95;
    public static final int GL_MAP1_TEXTURE_COORD_4 = 0xd96;
    public static final int GL_MAP1_VERTEX_3 = 0xd97;
    public static final int GL_MAP1_VERTEX_4 = 0xd98;
    public static final int GL_MAP2_COLOR_4 = 0xdb0;
    public static final int GL_MAP2_GRID_DOMAIN = 0xdd2;
    public static final int GL_MAP2_GRID_SEGMENTS = 0xdd3;
    public static final int GL_MAP2_INDEX = 0xdb1;
    public static final int GL_MAP2_NORMAL = 0xdb2;
    public static final int GL_MAP2_TEXTURE_COORD_1 = 0xdb3;
    public static final int GL_MAP2_TEXTURE_COORD_2 = 0xdb4;
    public static final int GL_MAP2_TEXTURE_COORD_3 = 0xdb5;
    public static final int GL_MAP2_TEXTURE_COORD_4 = 0xdb6;
    public static final int GL_MAP2_VERTEX_3 = 0xdb7;
    public static final int GL_MAP2_VERTEX_4 = 0xdb8;
    public static final int GL_MAP_COHERENT_BIT = 0x80;
    public static final int GL_MAP_COLOR = 0xd10;
    public static final int GL_MAP_FLUSH_EXPLICIT_BIT = 0x10;
    public static final int GL_MAP_INVALIDATE_BUFFER_BIT = 0x8;
    public static final int GL_MAP_INVALIDATE_RANGE_BIT = 0x4;
    public static final int GL_MAP_PERSISTENT_BIT = 0x40;
    public static final int GL_MAP_READ_BIT = 0x1;
    public static final int GL_MAP_STENCIL = 0xd11;
    public static final int GL_MAP_UNSYNCHRONIZED_BIT = 0x20;
    public static final int GL_MAP_WRITE_BIT = 0x2;
    public static final int GL_MATRIX_MODE = 0xba0;
    public static final int GL_MATRIX_STRIDE = 0x92ff;
    public static final int GL_MAX = 0x8008;
    public static final int GL_MAX_3D_TEXTURE_SIZE = 0x8073;
    public static final int GL_MAX_ARRAY_TEXTURE_LAYERS = 0x88ff;
    public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_BINDINGS = 0x92dc;
    public static final int GL_MAX_ATOMIC_COUNTER_BUFFER_SIZE = 0x92d8;
    public static final int GL_MAX_ATTRIB_STACK_DEPTH = 0xd35;
    public static final int GL_MAX_CLIENT_ATTRIB_STACK_DEPTH = 0xd3b;
    public static final int GL_MAX_CLIP_DISTANCES = 0xd32;
    public static final int GL_MAX_CLIP_PLANES = 0xd32;
    public static final int GL_MAX_COLOR_ATTACHMENTS = 0x8cdf;
    public static final int GL_MAX_COLOR_TEXTURE_SAMPLES = 0x910e;
    public static final int GL_MAX_COMBINED_ATOMIC_COUNTERS = 0x92d7;
    public static final int GL_MAX_COMBINED_ATOMIC_COUNTER_BUFFERS = 0x92d1;
    public static final int GL_MAX_COMBINED_CLIP_AND_CULL_DISTANCES = 0x82fa;
    public static final int GL_MAX_COMBINED_COMPUTE_UNIFORM_COMPONENTS = 0x8266;
    public static final int GL_MAX_COMBINED_DIMENSIONS = 0x8282;
    public static final int GL_MAX_COMBINED_FRAGMENT_UNIFORM_COMPONENTS = 0x8a33;
    public static final int GL_MAX_COMBINED_GEOMETRY_UNIFORM_COMPONENTS = 0x8a32;
    public static final int GL_MAX_COMBINED_IMAGE_UNIFORMS = 0x90cf;
    public static final int GL_MAX_COMBINED_IMAGE_UNITS_AND_FRAGMENT_OUTPUTS = 0x8f39;
    public static final int GL_MAX_COMBINED_SHADER_OUTPUT_RESOURCES = 0x8f39;
    public static final int GL_MAX_COMBINED_SHADER_STORAGE_BLOCKS = 0x90dc;
    public static final int GL_MAX_COMBINED_TESS_CONTROL_UNIFORM_COMPONENTS = 0x8e1e;
    public static final int GL_MAX_COMBINED_TESS_EVALUATION_UNIFORM_COMPONENTS = 0x8e1f;
    public static final int GL_MAX_COMBINED_TEXTURE_IMAGE_UNITS = 0x8b4d;
    public static final int GL_MAX_COMBINED_UNIFORM_BLOCKS = 0x8a2e;
    public static final int GL_MAX_COMBINED_VERTEX_UNIFORM_COMPONENTS = 0x8a31;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTERS = 0x8265;
    public static final int GL_MAX_COMPUTE_ATOMIC_COUNTER_BUFFERS = 0x8264;
    public static final int GL_MAX_COMPUTE_FIXED_GROUP_INVOCATIONS_ARB = 0x90eb;
    public static final int GL_MAX_COMPUTE_FIXED_GROUP_SIZE_ARB = 0x91bf;
    public static final int GL_MAX_COMPUTE_IMAGE_UNIFORMS = 0x91bd;
    public static final int GL_MAX_COMPUTE_SHADER_STORAGE_BLOCKS = 0x90db;
    public static final int GL_MAX_COMPUTE_SHARED_MEMORY_SIZE = 0x8262;
    public static final int GL_MAX_COMPUTE_TEXTURE_IMAGE_UNITS = 0x91bc;
    public static final int GL_MAX_COMPUTE_UNIFORM_BLOCKS = 0x91bb;
    public static final int GL_MAX_COMPUTE_UNIFORM_COMPONENTS = 0x8263;
    public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_INVOCATIONS_ARB = 0x9344;
    public static final int GL_MAX_COMPUTE_VARIABLE_GROUP_SIZE_ARB = 0x9345;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_COUNT = 0x91be;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_INVOCATIONS = 0x90eb;
    public static final int GL_MAX_COMPUTE_WORK_GROUP_SIZE = 0x91bf;
    public static final int GL_MAX_CUBE_MAP_TEXTURE_SIZE = 0x851c;
    public static final int GL_MAX_CULL_DISTANCES = 0x82f9;
    public static final int GL_MAX_DEBUG_GROUP_STACK_DEPTH = 0x826c;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES = 0x9144;
    public static final int GL_MAX_DEBUG_LOGGED_MESSAGES_ARB = 0x9144;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH = 0x9143;
    public static final int GL_MAX_DEBUG_MESSAGE_LENGTH_ARB = 0x9143;
    public static final int GL_MAX_DEPTH = 0x8280;
    public static final int GL_MAX_DEPTH_TEXTURE_SAMPLES = 0x910f;
    public static final int GL_MAX_DRAW_BUFFERS = 0x8824;
    public static final int GL_MAX_DUAL_SOURCE_DRAW_BUFFERS = 0x88fc;
    public static final int GL_MAX_ELEMENTS_INDICES = 0x80e9;
    public static final int GL_MAX_ELEMENTS_INDICES_WIN = 0x80e9;
    public static final int GL_MAX_ELEMENTS_VERTICES = 0x80e8;
    public static final int GL_MAX_ELEMENTS_VERTICES_WIN = 0x80e8;
    public static final int GL_MAX_ELEMENT_INDEX = 0x8d6b;
    public static final int GL_MAX_EVAL_ORDER = 0xd30;
    public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTERS = 0x92d6;
    public static final int GL_MAX_FRAGMENT_ATOMIC_COUNTER_BUFFERS = 0x92d0;
    public static final int GL_MAX_FRAGMENT_IMAGE_UNIFORMS = 0x90ce;
    public static final int GL_MAX_FRAGMENT_INPUT_COMPONENTS = 0x9125;
    public static final int GL_MAX_FRAGMENT_INTERPOLATION_OFFSET = 0x8e5c;
    public static final int GL_MAX_FRAGMENT_SHADER_STORAGE_BLOCKS = 0x90da;
    public static final int GL_MAX_FRAGMENT_UNIFORM_BLOCKS = 0x8a2d;
    public static final int GL_MAX_FRAGMENT_UNIFORM_COMPONENTS = 0x8b49;
    public static final int GL_MAX_FRAGMENT_UNIFORM_VECTORS = 0x8dfd;
    public static final int GL_MAX_FRAMEBUFFER_HEIGHT = 0x9316;
    public static final int GL_MAX_FRAMEBUFFER_LAYERS = 0x9317;
    public static final int GL_MAX_FRAMEBUFFER_SAMPLES = 0x9318;
    public static final int GL_MAX_FRAMEBUFFER_WIDTH = 0x9315;
    public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTERS = 0x92d5;
    public static final int GL_MAX_GEOMETRY_ATOMIC_COUNTER_BUFFERS = 0x92cf;
    public static final int GL_MAX_GEOMETRY_IMAGE_UNIFORMS = 0x90cd;
    public static final int GL_MAX_GEOMETRY_INPUT_COMPONENTS = 0x9123;
    public static final int GL_MAX_GEOMETRY_OUTPUT_COMPONENTS = 0x9124;
    public static final int GL_MAX_GEOMETRY_OUTPUT_VERTICES = 0x8de0;
    public static final int GL_MAX_GEOMETRY_SHADER_INVOCATIONS = 0x8e5a;
    public static final int GL_MAX_GEOMETRY_SHADER_STORAGE_BLOCKS = 0x90d7;
    public static final int GL_MAX_GEOMETRY_TEXTURE_IMAGE_UNITS = 0x8c29;
    public static final int GL_MAX_GEOMETRY_TOTAL_OUTPUT_COMPONENTS = 0x8de1;
    public static final int GL_MAX_GEOMETRY_UNIFORM_BLOCKS = 0x8a2c;
    public static final int GL_MAX_GEOMETRY_UNIFORM_COMPONENTS = 0x8ddf;
    public static final int GL_MAX_HEIGHT = 0x827f;
    public static final int GL_MAX_IMAGE_SAMPLES = 0x906d;
    public static final int GL_MAX_IMAGE_UNITS = 0x8f38;
    public static final int GL_MAX_INTEGER_SAMPLES = 0x9110;
    public static final int GL_MAX_LABEL_LENGTH = 0x82e8;
    public static final int GL_MAX_LAYERS = 0x8281;
    public static final int GL_MAX_LIGHTS = 0xd31;
    public static final int GL_MAX_LIST_NESTING = 0xb31;
    public static final int GL_MAX_MODELVIEW_STACK_DEPTH = 0xd36;
    public static final int GL_MAX_NAME_LENGTH = 0x92f6;
    public static final int GL_MAX_NAME_STACK_DEPTH = 0xd37;
    public static final int GL_MAX_NUM_ACTIVE_VARIABLES = 0x92f7;
    public static final int GL_MAX_NUM_COMPATIBLE_SUBROUTINES = 0x92f8;
    public static final int GL_MAX_PATCH_VERTICES = 0x8e7d;
    public static final int GL_MAX_PIXEL_MAP_TABLE = 0xd34;
    public static final int GL_MAX_PROGRAM_TEXEL_OFFSET = 0x8905;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_COMPONENTS_ARB = 0x8f9f;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET = 0x8e5f;
    public static final int GL_MAX_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 0x8e5f;
    public static final int GL_MAX_PROJECTION_STACK_DEPTH = 0xd38;
    public static final int GL_MAX_RECTANGLE_TEXTURE_SIZE = 0x84f8;
    public static final int GL_MAX_RENDERBUFFER_SIZE = 0x84e8;
    public static final int GL_MAX_SAMPLES = 0x8d57;
    public static final int GL_MAX_SAMPLE_MASK_WORDS = 0x8e59;
    public static final int GL_MAX_SERVER_WAIT_TIMEOUT = 0x9111;
    public static final int GL_MAX_SHADER_STORAGE_BLOCK_SIZE = 0x90de;
    public static final int GL_MAX_SHADER_STORAGE_BUFFER_BINDINGS = 0x90dd;
    public static final int GL_MAX_SPARSE_3D_TEXTURE_SIZE_ARB = 0x9199;
    public static final int GL_MAX_SPARSE_ARRAY_TEXTURE_LAYERS_ARB = 0x919a;
    public static final int GL_MAX_SPARSE_TEXTURE_SIZE_ARB = 0x9198;
    public static final int GL_MAX_SUBROUTINES = 0x8de7;
    public static final int GL_MAX_SUBROUTINE_UNIFORM_LOCATIONS = 0x8de8;
    public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTERS = 0x92d3;
    public static final int GL_MAX_TESS_CONTROL_ATOMIC_COUNTER_BUFFERS = 0x92cd;
    public static final int GL_MAX_TESS_CONTROL_IMAGE_UNIFORMS = 0x90cb;
    public static final int GL_MAX_TESS_CONTROL_INPUT_COMPONENTS = 0x886c;
    public static final int GL_MAX_TESS_CONTROL_OUTPUT_COMPONENTS = 0x8e83;
    public static final int GL_MAX_TESS_CONTROL_SHADER_STORAGE_BLOCKS = 0x90d8;
    public static final int GL_MAX_TESS_CONTROL_TEXTURE_IMAGE_UNITS = 0x8e81;
    public static final int GL_MAX_TESS_CONTROL_TOTAL_OUTPUT_COMPONENTS = 0x8e85;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_BLOCKS = 0x8e89;
    public static final int GL_MAX_TESS_CONTROL_UNIFORM_COMPONENTS = 0x8e7f;
    public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTERS = 0x92d4;
    public static final int GL_MAX_TESS_EVALUATION_ATOMIC_COUNTER_BUFFERS = 0x92ce;
    public static final int GL_MAX_TESS_EVALUATION_IMAGE_UNIFORMS = 0x90cc;
    public static final int GL_MAX_TESS_EVALUATION_INPUT_COMPONENTS = 0x886d;
    public static final int GL_MAX_TESS_EVALUATION_OUTPUT_COMPONENTS = 0x8e86;
    public static final int GL_MAX_TESS_EVALUATION_SHADER_STORAGE_BLOCKS = 0x90d9;
    public static final int GL_MAX_TESS_EVALUATION_TEXTURE_IMAGE_UNITS = 0x8e82;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_BLOCKS = 0x8e8a;
    public static final int GL_MAX_TESS_EVALUATION_UNIFORM_COMPONENTS = 0x8e80;
    public static final int GL_MAX_TESS_GEN_LEVEL = 0x8e7e;
    public static final int GL_MAX_TESS_PATCH_COMPONENTS = 0x8e84;
    public static final int GL_MAX_TEXTURE_BUFFER_SIZE = 0x8c2b;
    public static final int GL_MAX_TEXTURE_IMAGE_UNITS = 0x8872;
    public static final int GL_MAX_TEXTURE_LOD_BIAS = 0x84fd;
    public static final int GL_MAX_TEXTURE_SIZE = 0xd33;
    public static final int GL_MAX_TEXTURE_STACK_DEPTH = 0xd39;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_BUFFERS = 0x8e70;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_INTERLEAVED_COMPONENTS = 0x8c8a;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_ATTRIBS = 0x8c8b;
    public static final int GL_MAX_TRANSFORM_FEEDBACK_SEPARATE_COMPONENTS = 0x8c80;
    public static final int GL_MAX_UNIFORM_BLOCK_SIZE = 0x8a30;
    public static final int GL_MAX_UNIFORM_BUFFER_BINDINGS = 0x8a2f;
    public static final int GL_MAX_UNIFORM_LOCATIONS = 0x826e;
    public static final int GL_MAX_VARYING_COMPONENTS = 0x8b4b;
    public static final int GL_MAX_VARYING_FLOATS = 0x8b4b;
    public static final int GL_MAX_VARYING_VECTORS = 0x8dfc;
    public static final int GL_MAX_VERTEX_ATOMIC_COUNTERS = 0x92d2;
    public static final int GL_MAX_VERTEX_ATOMIC_COUNTER_BUFFERS = 0x92cc;
    public static final int GL_MAX_VERTEX_ATTRIBS = 0x8869;
    public static final int GL_MAX_VERTEX_ATTRIB_BINDINGS = 0x82da;
    public static final int GL_MAX_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82d9;
    public static final int GL_MAX_VERTEX_ATTRIB_STRIDE = 0x82e5;
    public static final int GL_MAX_VERTEX_IMAGE_UNIFORMS = 0x90ca;
    public static final int GL_MAX_VERTEX_OUTPUT_COMPONENTS = 0x9122;
    public static final int GL_MAX_VERTEX_SHADER_STORAGE_BLOCKS = 0x90d6;
    public static final int GL_MAX_VERTEX_STREAMS = 0x8e71;
    public static final int GL_MAX_VERTEX_TEXTURE_IMAGE_UNITS = 0x8b4c;
    public static final int GL_MAX_VERTEX_UNIFORM_BLOCKS = 0x8a2b;
    public static final int GL_MAX_VERTEX_UNIFORM_COMPONENTS = 0x8b4a;
    public static final int GL_MAX_VERTEX_UNIFORM_VECTORS = 0x8dfb;
    public static final int GL_MAX_VIEWPORTS = 0x825b;
    public static final int GL_MAX_VIEWPORT_DIMS = 0xd3a;
    public static final int GL_MAX_WIDTH = 0x827e;
    public static final int GL_MEDIUM_FLOAT = 0x8df1;
    public static final int GL_MEDIUM_INT = 0x8df4;
    public static final int GL_MIN = 0x8007;
    public static final int GL_MINOR_VERSION = 0x821c;
    public static final int GL_MIN_FRAGMENT_INTERPOLATION_OFFSET = 0x8e5b;
    public static final int GL_MIN_MAP_BUFFER_ALIGNMENT = 0x90bc;
    public static final int GL_MIN_PROGRAM_TEXEL_OFFSET = 0x8904;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET = 0x8e5e;
    public static final int GL_MIN_PROGRAM_TEXTURE_GATHER_OFFSET_ARB = 0x8e5e;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE = 0x8c37;
    public static final int GL_MIN_SAMPLE_SHADING_VALUE_ARB = 0x8c37;
    public static final int GL_MIPMAP = 0x8293;
    public static final int GL_MIRRORED_REPEAT = 0x8370;
    public static final int GL_MIRROR_CLAMP_TO_EDGE = 0x8743;
    public static final int GL_MODELVIEW = 0x1700;
    public static final int GL_MODELVIEW_MATRIX = 0xba6;
    public static final int GL_MODELVIEW_STACK_DEPTH = 0xba3;
    public static final int GL_MODULATE = 0x2100;
    public static final int GL_MULT = 0x103;
    public static final int GL_MULTISAMPLE = 0x809d;
    public static final int GL_N3F_V3F = 0x2a25;
    public static final int GL_NAMED_STRING_LENGTH_ARB = 0x8de9;
    public static final int GL_NAMED_STRING_TYPE_ARB = 0x8dea;
    public static final int GL_NAME_LENGTH = 0x92f9;
    public static final int GL_NAME_STACK_DEPTH = 0xd70;
    public static final int GL_NAND = 0x150e;
    public static final int GL_NEAREST = 0x2600;
    public static final int GL_NEAREST_MIPMAP_LINEAR = 0x2702;
    public static final int GL_NEAREST_MIPMAP_NEAREST = 0x2700;
    public static final int GL_NEGATIVE_ONE_TO_ONE = 0x935e;
    public static final int GL_NEVER = 0x200;
    public static final int GL_NICEST = 0x1102;
    public static final int GL_NONE = 0x0;
    public static final int GL_NOOP = 0x1505;
    public static final int GL_NOR = 0x1508;
    public static final int GL_NORMALIZE = 0xba1;
    public static final int GL_NORMAL_ARRAY = 0x8075;
    public static final int GL_NORMAL_ARRAY_COUNT_EXT = 0x8080;
    public static final int GL_NORMAL_ARRAY_EXT = 0x8075;
    public static final int GL_NORMAL_ARRAY_POINTER = 0x808f;
    public static final int GL_NORMAL_ARRAY_POINTER_EXT = 0x808f;
    public static final int GL_NORMAL_ARRAY_STRIDE = 0x807f;
    public static final int GL_NORMAL_ARRAY_STRIDE_EXT = 0x807f;
    public static final int GL_NORMAL_ARRAY_TYPE = 0x807e;
    public static final int GL_NORMAL_ARRAY_TYPE_EXT = 0x807e;
    public static final int GL_NOTEQUAL = 0x205;
    public static final int GL_NO_ERROR = 0x0;
    public static final int GL_NO_RESET_NOTIFICATION = 0x8261;
    public static final int GL_NO_RESET_NOTIFICATION_ARB = 0x8261;
    public static final int GL_NUM_ACTIVE_VARIABLES = 0x9304;
    public static final int GL_NUM_COMPATIBLE_SUBROUTINES = 0x8e4a;
    public static final int GL_NUM_COMPRESSED_TEXTURE_FORMATS = 0x86a2;
    public static final int GL_NUM_EXTENSIONS = 0x821d;
    public static final int GL_NUM_PROGRAM_BINARY_FORMATS = 0x87fe;
    public static final int GL_NUM_SAMPLE_COUNTS = 0x9380;
    public static final int GL_NUM_SHADER_BINARY_FORMATS = 0x8df9;
    public static final int GL_NUM_SHADING_LANGUAGE_VERSIONS = 0x82e9;
    public static final int GL_NUM_SPARSE_LEVELS_ARB = 0x91aa;
    public static final int GL_NUM_VIRTUAL_PAGE_SIZES_ARB = 0x91a8;
    public static final int GL_OBJECT_LINEAR = 0x2401;
    public static final int GL_OBJECT_PLANE = 0x2501;
    public static final int GL_OBJECT_TYPE = 0x9112;
    public static final int GL_OFFSET = 0x92fc;
    public static final int GL_ONE = 0x1;
    public static final int GL_ONE_MINUS_CONSTANT_ALPHA = 0x8004;
    public static final int GL_ONE_MINUS_CONSTANT_COLOR = 0x8002;
    public static final int GL_ONE_MINUS_DST_ALPHA = 0x305;
    public static final int GL_ONE_MINUS_DST_COLOR = 0x307;
    public static final int GL_ONE_MINUS_SRC1_ALPHA = 0x88fb;
    public static final int GL_ONE_MINUS_SRC1_COLOR = 0x88fa;
    public static final int GL_ONE_MINUS_SRC_ALPHA = 0x303;
    public static final int GL_ONE_MINUS_SRC_COLOR = 0x301;
    public static final int GL_OR = 0x1507;
    public static final int GL_ORDER = 0xa01;
    public static final int GL_OR_INVERTED = 0x150d;
    public static final int GL_OR_REVERSE = 0x150b;
    public static final int GL_OUT_OF_MEMORY = 0x505;
    public static final int GL_PACK_ALIGNMENT = 0xd05;
    public static final int GL_PACK_COMPRESSED_BLOCK_DEPTH = 0x912d;
    public static final int GL_PACK_COMPRESSED_BLOCK_HEIGHT = 0x912c;
    public static final int GL_PACK_COMPRESSED_BLOCK_SIZE = 0x912e;
    public static final int GL_PACK_COMPRESSED_BLOCK_WIDTH = 0x912b;
    public static final int GL_PACK_IMAGE_HEIGHT = 0x806c;
    public static final int GL_PACK_LSB_FIRST = 0xd01;
    public static final int GL_PACK_ROW_LENGTH = 0xd02;
    public static final int GL_PACK_SKIP_IMAGES = 0x806b;
    public static final int GL_PACK_SKIP_PIXELS = 0xd04;
    public static final int GL_PACK_SKIP_ROWS = 0xd03;
    public static final int GL_PACK_SWAP_BYTES = 0xd00;
    public static final int GL_PARAMETER_BUFFER_ARB = 0x80ee;
    public static final int GL_PARAMETER_BUFFER_BINDING_ARB = 0x80ef;
    public static final int GL_PASS_THROUGH_TOKEN = 0x700;
    public static final int GL_PATCHES = 0xe;
    public static final int GL_PATCH_DEFAULT_INNER_LEVEL = 0x8e73;
    public static final int GL_PATCH_DEFAULT_OUTER_LEVEL = 0x8e74;
    public static final int GL_PATCH_VERTICES = 0x8e72;
    public static final int GL_PERSPECTIVE_CORRECTION_HINT = 0xc50;
    public static final int GL_PHONG_HINT_WIN = 0x80eb;
    public static final int GL_PHONG_WIN = 0x80ea;
    public static final int GL_PIXEL_BUFFER_BARRIER_BIT = 0x80;
    public static final int GL_PIXEL_MAP_A_TO_A = 0xc79;
    public static final int GL_PIXEL_MAP_A_TO_A_SIZE = 0xcb9;
    public static final int GL_PIXEL_MAP_B_TO_B = 0xc78;
    public static final int GL_PIXEL_MAP_B_TO_B_SIZE = 0xcb8;
    public static final int GL_PIXEL_MAP_G_TO_G = 0xc77;
    public static final int GL_PIXEL_MAP_G_TO_G_SIZE = 0xcb7;
    public static final int GL_PIXEL_MAP_I_TO_A = 0xc75;
    public static final int GL_PIXEL_MAP_I_TO_A_SIZE = 0xcb5;
    public static final int GL_PIXEL_MAP_I_TO_B = 0xc74;
    public static final int GL_PIXEL_MAP_I_TO_B_SIZE = 0xcb4;
    public static final int GL_PIXEL_MAP_I_TO_G = 0xc73;
    public static final int GL_PIXEL_MAP_I_TO_G_SIZE = 0xcb3;
    public static final int GL_PIXEL_MAP_I_TO_I = 0xc70;
    public static final int GL_PIXEL_MAP_I_TO_I_SIZE = 0xcb0;
    public static final int GL_PIXEL_MAP_I_TO_R = 0xc72;
    public static final int GL_PIXEL_MAP_I_TO_R_SIZE = 0xcb2;
    public static final int GL_PIXEL_MAP_R_TO_R = 0xc76;
    public static final int GL_PIXEL_MAP_R_TO_R_SIZE = 0xcb6;
    public static final int GL_PIXEL_MAP_S_TO_S = 0xc71;
    public static final int GL_PIXEL_MAP_S_TO_S_SIZE = 0xcb1;
    public static final int GL_PIXEL_MODE_BIT = 0x20;
    public static final int GL_PIXEL_PACK_BUFFER = 0x88eb;
    public static final int GL_PIXEL_PACK_BUFFER_BINDING = 0x88ed;
    public static final int GL_PIXEL_UNPACK_BUFFER = 0x88ec;
    public static final int GL_PIXEL_UNPACK_BUFFER_BINDING = 0x88ef;
    public static final int GL_POINT = 0x1b00;
    public static final int GL_POINTS = 0x0;
    public static final int GL_POINT_BIT = 0x2;
    public static final int GL_POINT_FADE_THRESHOLD_SIZE = 0x8128;
    public static final int GL_POINT_SIZE = 0xb11;
    public static final int GL_POINT_SIZE_GRANULARITY = 0xb13;
    public static final int GL_POINT_SIZE_RANGE = 0xb12;
    public static final int GL_POINT_SMOOTH = 0xb10;
    public static final int GL_POINT_SMOOTH_HINT = 0xc51;
    public static final int GL_POINT_SPRITE_COORD_ORIGIN = 0x8ca0;
    public static final int GL_POINT_TOKEN = 0x701;
    public static final int GL_POLYGON = 0x9;
    public static final int GL_POLYGON_BIT = 0x8;
    public static final int GL_POLYGON_MODE = 0xb40;
    public static final int GL_POLYGON_OFFSET_FACTOR = 0x8038;
    public static final int GL_POLYGON_OFFSET_FILL = 0x8037;
    public static final int GL_POLYGON_OFFSET_LINE = 0x2a02;
    public static final int GL_POLYGON_OFFSET_POINT = 0x2a01;
    public static final int GL_POLYGON_OFFSET_UNITS = 0x2a00;
    public static final int GL_POLYGON_SMOOTH = 0xb41;
    public static final int GL_POLYGON_SMOOTH_HINT = 0xc53;
    public static final int GL_POLYGON_STIPPLE = 0xb42;
    public static final int GL_POLYGON_STIPPLE_BIT = 0x10;
    public static final int GL_POLYGON_TOKEN = 0x703;
    public static final int GL_POSITION = 0x1203;
    public static final int GL_PRIMITIVES_GENERATED = 0x8c87;
    public static final int GL_PRIMITIVES_SUBMITTED_ARB = 0x82ef;
    public static final int GL_PRIMITIVE_RESTART = 0x8f9d;
    public static final int GL_PRIMITIVE_RESTART_FIXED_INDEX = 0x8d69;
    public static final int GL_PRIMITIVE_RESTART_FOR_PATCHES_SUPPORTED = 0x8221;
    public static final int GL_PRIMITIVE_RESTART_INDEX = 0x8f9e;
    public static final int GL_PROGRAM = 0x82e2;
    public static final int GL_PROGRAM_BINARY_FORMATS = 0x87ff;
    public static final int GL_PROGRAM_BINARY_LENGTH = 0x8741;
    public static final int GL_PROGRAM_BINARY_RETRIEVABLE_HINT = 0x8257;
    public static final int GL_PROGRAM_INPUT = 0x92e3;
    public static final int GL_PROGRAM_OUTPUT = 0x92e4;
    public static final int GL_PROGRAM_PIPELINE = 0x82e4;
    public static final int GL_PROGRAM_PIPELINE_BINDING = 0x825a;
    public static final int GL_PROGRAM_POINT_SIZE = 0x8642;
    public static final int GL_PROGRAM_SEPARABLE = 0x8258;
    public static final int GL_PROJECTION = 0x1701;
    public static final int GL_PROJECTION_MATRIX = 0xba7;
    public static final int GL_PROJECTION_STACK_DEPTH = 0xba4;
    public static final int GL_PROVOKING_VERTEX = 0x8e4f;
    public static final int GL_PROXY_TEXTURE_1D = 0x8063;
    public static final int GL_PROXY_TEXTURE_1D_ARRAY = 0x8c19;
    public static final int GL_PROXY_TEXTURE_2D = 0x8064;
    public static final int GL_PROXY_TEXTURE_2D_ARRAY = 0x8c1b;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE = 0x9101;
    public static final int GL_PROXY_TEXTURE_2D_MULTISAMPLE_ARRAY = 0x9103;
    public static final int GL_PROXY_TEXTURE_3D = 0x8070;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP = 0x851b;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY = 0x900b;
    public static final int GL_PROXY_TEXTURE_CUBE_MAP_ARRAY_ARB = 0x900b;
    public static final int GL_PROXY_TEXTURE_RECTANGLE = 0x84f7;
    public static final int GL_Q = 0x2003;
    public static final int GL_QUADRATIC_ATTENUATION = 0x1209;
    public static final int GL_QUADS = 0x7;
    public static final int GL_QUADS_FOLLOW_PROVOKING_VERTEX_CONVENTION = 0x8e4c;
    public static final int GL_QUAD_STRIP = 0x8;
    public static final int GL_QUERY = 0x82e3;
    public static final int GL_QUERY_BUFFER = 0x9192;
    public static final int GL_QUERY_BUFFER_BARRIER_BIT = 0x8000;
    public static final int GL_QUERY_BUFFER_BINDING = 0x9193;
    public static final int GL_QUERY_BY_REGION_NO_WAIT = 0x8e16;
    public static final int GL_QUERY_BY_REGION_NO_WAIT_INVERTED = 0x8e1a;
    public static final int GL_QUERY_BY_REGION_WAIT = 0x8e15;
    public static final int GL_QUERY_BY_REGION_WAIT_INVERTED = 0x8e19;
    public static final int GL_QUERY_COUNTER_BITS = 0x8864;
    public static final int GL_QUERY_NO_WAIT = 0x8e14;
    public static final int GL_QUERY_NO_WAIT_INVERTED = 0x8e18;
    public static final int GL_QUERY_RESULT = 0x8866;
    public static final int GL_QUERY_RESULT_AVAILABLE = 0x8867;
    public static final int GL_QUERY_RESULT_NO_WAIT = 0x9194;
    public static final int GL_QUERY_TARGET = 0x82ea;
    public static final int GL_QUERY_WAIT = 0x8e13;
    public static final int GL_QUERY_WAIT_INVERTED = 0x8e17;
    public static final int GL_R = 0x2002;
    public static final int GL_R11F_G11F_B10F = 0x8c3a;
    public static final int GL_R16 = 0x822a;
    public static final int GL_R16F = 0x822d;
    public static final int GL_R16I = 0x8233;
    public static final int GL_R16UI = 0x8234;
    public static final int GL_R16_SNORM = 0x8f98;
    public static final int GL_R32F = 0x822e;
    public static final int GL_R32I = 0x8235;
    public static final int GL_R32UI = 0x8236;
    public static final int GL_R3_G3_B2 = 0x2a10;
    public static final int GL_R8 = 0x8229;
    public static final int GL_R8I = 0x8231;
    public static final int GL_R8UI = 0x8232;
    public static final int GL_R8_SNORM = 0x8f94;
    public static final int GL_RASTERIZER_DISCARD = 0x8c89;
    public static final int GL_READ_BUFFER = 0xc02;
    public static final int GL_READ_FRAMEBUFFER = 0x8ca8;
    public static final int GL_READ_FRAMEBUFFER_BINDING = 0x8caa;
    public static final int GL_READ_ONLY = 0x88b8;
    public static final int GL_READ_PIXELS = 0x828c;
    public static final int GL_READ_PIXELS_FORMAT = 0x828d;
    public static final int GL_READ_PIXELS_TYPE = 0x828e;
    public static final int GL_READ_WRITE = 0x88ba;
    public static final int GL_RED = 0x1903;
    public static final int GL_RED_BIAS = 0xd15;
    public static final int GL_RED_BITS = 0xd52;
    public static final int GL_RED_INTEGER = 0x8d94;
    public static final int GL_RED_SCALE = 0xd14;
    public static final int GL_REFERENCED_BY_COMPUTE_SHADER = 0x930b;
    public static final int GL_REFERENCED_BY_FRAGMENT_SHADER = 0x930a;
    public static final int GL_REFERENCED_BY_GEOMETRY_SHADER = 0x9309;
    public static final int GL_REFERENCED_BY_TESS_CONTROL_SHADER = 0x9307;
    public static final int GL_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x9308;
    public static final int GL_REFERENCED_BY_VERTEX_SHADER = 0x9306;
    public static final int GL_RENDER = 0x1c00;
    public static final int GL_RENDERBUFFER = 0x8d41;
    public static final int GL_RENDERBUFFER_ALPHA_SIZE = 0x8d53;
    public static final int GL_RENDERBUFFER_BINDING = 0x8ca7;
    public static final int GL_RENDERBUFFER_BLUE_SIZE = 0x8d52;
    public static final int GL_RENDERBUFFER_DEPTH_SIZE = 0x8d54;
    public static final int GL_RENDERBUFFER_GREEN_SIZE = 0x8d51;
    public static final int GL_RENDERBUFFER_HEIGHT = 0x8d43;
    public static final int GL_RENDERBUFFER_INTERNAL_FORMAT = 0x8d44;
    public static final int GL_RENDERBUFFER_RED_SIZE = 0x8d50;
    public static final int GL_RENDERBUFFER_SAMPLES = 0x8cab;
    public static final int GL_RENDERBUFFER_STENCIL_SIZE = 0x8d55;
    public static final int GL_RENDERBUFFER_WIDTH = 0x8d42;
    public static final int GL_RENDERER = 0x1f01;
    public static final int GL_RENDER_MODE = 0xc40;
    public static final int GL_REPEAT = 0x2901;
    public static final int GL_REPLACE = 0x1e01;
    public static final int GL_RESET_NOTIFICATION_STRATEGY = 0x8256;
    public static final int GL_RESET_NOTIFICATION_STRATEGY_ARB = 0x8256;
    public static final int GL_RETURN = 0x102;
    public static final int GL_RG = 0x8227;
    public static final int GL_RG16 = 0x822c;
    public static final int GL_RG16F = 0x822f;
    public static final int GL_RG16I = 0x8239;
    public static final int GL_RG16UI = 0x823a;
    public static final int GL_RG16_SNORM = 0x8f99;
    public static final int GL_RG32F = 0x8230;
    public static final int GL_RG32I = 0x823b;
    public static final int GL_RG32UI = 0x823c;
    public static final int GL_RG8 = 0x822b;
    public static final int GL_RG8I = 0x8237;
    public static final int GL_RG8UI = 0x8238;
    public static final int GL_RG8_SNORM = 0x8f95;
    public static final int GL_RGB = 0x1907;
    public static final int GL_RGB10 = 0x8052;
    public static final int GL_RGB10_A2 = 0x8059;
    public static final int GL_RGB10_A2UI = 0x906f;
    public static final int GL_RGB12 = 0x8053;
    public static final int GL_RGB16 = 0x8054;
    public static final int GL_RGB16F = 0x881b;
    public static final int GL_RGB16I = 0x8d89;
    public static final int GL_RGB16UI = 0x8d77;
    public static final int GL_RGB16_SNORM = 0x8f9a;
    public static final int GL_RGB32F = 0x8815;
    public static final int GL_RGB32I = 0x8d83;
    public static final int GL_RGB32UI = 0x8d71;
    public static final int GL_RGB4 = 0x804f;
    public static final int GL_RGB5 = 0x8050;
    public static final int GL_RGB565 = 0x8d62;
    public static final int GL_RGB5_A1 = 0x8057;
    public static final int GL_RGB8 = 0x8051;
    public static final int GL_RGB8I = 0x8d8f;
    public static final int GL_RGB8UI = 0x8d7d;
    public static final int GL_RGB8_SNORM = 0x8f96;
    public static final int GL_RGB9_E5 = 0x8c3d;
    public static final int GL_RGBA = 0x1908;
    public static final int GL_RGBA12 = 0x805a;
    public static final int GL_RGBA16 = 0x805b;
    public static final int GL_RGBA16F = 0x881a;
    public static final int GL_RGBA16I = 0x8d88;
    public static final int GL_RGBA16UI = 0x8d76;
    public static final int GL_RGBA16_SNORM = 0x8f9b;
    public static final int GL_RGBA2 = 0x8055;
    public static final int GL_RGBA32F = 0x8814;
    public static final int GL_RGBA32I = 0x8d82;
    public static final int GL_RGBA32UI = 0x8d70;
    public static final int GL_RGBA4 = 0x8056;
    public static final int GL_RGBA8 = 0x8058;
    public static final int GL_RGBA8I = 0x8d8e;
    public static final int GL_RGBA8UI = 0x8d7c;
    public static final int GL_RGBA8_SNORM = 0x8f97;
    public static final int GL_RGBA_INTEGER = 0x8d99;
    public static final int GL_RGBA_MODE = 0xc31;
    public static final int GL_RGB_INTEGER = 0x8d98;
    public static final int GL_RG_INTEGER = 0x8228;
    public static final int GL_RIGHT = 0x407;
    public static final int GL_S = 0x2000;
    public static final int GL_SAMPLER = 0x82e6;
    public static final int GL_SAMPLER_1D = 0x8b5d;
    public static final int GL_SAMPLER_1D_ARRAY = 0x8dc0;
    public static final int GL_SAMPLER_1D_ARRAY_SHADOW = 0x8dc3;
    public static final int GL_SAMPLER_1D_SHADOW = 0x8b61;
    public static final int GL_SAMPLER_2D = 0x8b5e;
    public static final int GL_SAMPLER_2D_ARRAY = 0x8dc1;
    public static final int GL_SAMPLER_2D_ARRAY_SHADOW = 0x8dc4;
    public static final int GL_SAMPLER_2D_MULTISAMPLE = 0x9108;
    public static final int GL_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910b;
    public static final int GL_SAMPLER_2D_RECT = 0x8b63;
    public static final int GL_SAMPLER_2D_RECT_SHADOW = 0x8b64;
    public static final int GL_SAMPLER_2D_SHADOW = 0x8b62;
    public static final int GL_SAMPLER_3D = 0x8b5f;
    public static final int GL_SAMPLER_BINDING = 0x8919;
    public static final int GL_SAMPLER_BUFFER = 0x8dc2;
    public static final int GL_SAMPLER_CUBE = 0x8b60;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY = 0x900c;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_ARB = 0x900c;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW = 0x900d;
    public static final int GL_SAMPLER_CUBE_MAP_ARRAY_SHADOW_ARB = 0x900d;
    public static final int GL_SAMPLER_CUBE_SHADOW = 0x8dc5;
    public static final int GL_SAMPLES = 0x80a9;
    public static final int GL_SAMPLES_PASSED = 0x8914;
    public static final int GL_SAMPLE_ALPHA_TO_COVERAGE = 0x809e;
    public static final int GL_SAMPLE_ALPHA_TO_ONE = 0x809f;
    public static final int GL_SAMPLE_BUFFERS = 0x80a8;
    public static final int GL_SAMPLE_COVERAGE = 0x80a0;
    public static final int GL_SAMPLE_COVERAGE_INVERT = 0x80ab;
    public static final int GL_SAMPLE_COVERAGE_VALUE = 0x80aa;
    public static final int GL_SAMPLE_MASK = 0x8e51;
    public static final int GL_SAMPLE_MASK_VALUE = 0x8e52;
    public static final int GL_SAMPLE_POSITION = 0x8e50;
    public static final int GL_SAMPLE_SHADING = 0x8c36;
    public static final int GL_SAMPLE_SHADING_ARB = 0x8c36;
    public static final int GL_SCISSOR_BIT = 0x80000;
    public static final int GL_SCISSOR_BOX = 0xc10;
    public static final int GL_SCISSOR_TEST = 0xc11;
    public static final int GL_SELECT = 0x1c02;
    public static final int GL_SELECTION_BUFFER_POINTER = 0xdf3;
    public static final int GL_SELECTION_BUFFER_SIZE = 0xdf4;
    public static final int GL_SEPARATE_ATTRIBS = 0x8c8d;
    public static final int GL_SET = 0x150f;
    public static final int GL_SHADER = 0x82e1;
    public static final int GL_SHADER_BINARY_FORMATS = 0x8df8;
    public static final int GL_SHADER_COMPILER = 0x8dfa;
    public static final int GL_SHADER_IMAGE_ACCESS_BARRIER_BIT = 0x20;
    public static final int GL_SHADER_IMAGE_ATOMIC = 0x82a6;
    public static final int GL_SHADER_IMAGE_LOAD = 0x82a4;
    public static final int GL_SHADER_IMAGE_STORE = 0x82a5;
    public static final int GL_SHADER_INCLUDE_ARB = 0x8dae;
    public static final int GL_SHADER_SOURCE_LENGTH = 0x8b88;
    public static final int GL_SHADER_STORAGE_BARRIER_BIT = 0x2000;
    public static final int GL_SHADER_STORAGE_BLOCK = 0x92e6;
    public static final int GL_SHADER_STORAGE_BUFFER = 0x90d2;
    public static final int GL_SHADER_STORAGE_BUFFER_BINDING = 0x90d3;
    public static final int GL_SHADER_STORAGE_BUFFER_OFFSET_ALIGNMENT = 0x90df;
    public static final int GL_SHADER_STORAGE_BUFFER_SIZE = 0x90d5;
    public static final int GL_SHADER_STORAGE_BUFFER_START = 0x90d4;
    public static final int GL_SHADER_TYPE = 0x8b4f;
    public static final int GL_SHADE_MODEL = 0xb54;
    public static final int GL_SHADING_LANGUAGE_VERSION = 0x8b8c;
    public static final int GL_SHININESS = 0x1601;
    public static final int GL_SHORT = 0x1402;
    public static final int GL_SIGNALED = 0x9119;
    public static final int GL_SIGNED_NORMALIZED = 0x8f9c;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_TEST = 0x82ac;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_DEPTH_WRITE = 0x82ae;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_TEST = 0x82ad;
    public static final int GL_SIMULTANEOUS_TEXTURE_AND_STENCIL_WRITE = 0x82af;
    public static final int GL_SMOOTH = 0x1d01;
    public static final int GL_SMOOTH_LINE_WIDTH_GRANULARITY = 0xb23;
    public static final int GL_SMOOTH_LINE_WIDTH_RANGE = 0xb22;
    public static final int GL_SMOOTH_POINT_SIZE_GRANULARITY = 0xb13;
    public static final int GL_SMOOTH_POINT_SIZE_RANGE = 0xb12;
    public static final int GL_SPARSE_BUFFER_PAGE_SIZE_ARB = 0x82f8;
    public static final int GL_SPARSE_STORAGE_BIT_ARB = 0x400;
    public static final int GL_SPARSE_TEXTURE_FULL_ARRAY_CUBE_MIPMAPS_ARB = 0x91a9;
    public static final int GL_SPECULAR = 0x1202;
    public static final int GL_SPHERE_MAP = 0x2402;
    public static final int GL_SPOT_CUTOFF = 0x1206;
    public static final int GL_SPOT_DIRECTION = 0x1204;
    public static final int GL_SPOT_EXPONENT = 0x1205;
    public static final int GL_SRC1_ALPHA = 0x8589;
    public static final int GL_SRC1_COLOR = 0x88f9;
    public static final int GL_SRC_ALPHA = 0x302;
    public static final int GL_SRC_ALPHA_SATURATE = 0x308;
    public static final int GL_SRC_COLOR = 0x300;
    public static final int GL_SRGB = 0x8c40;
    public static final int GL_SRGB8 = 0x8c41;
    public static final int GL_SRGB8_ALPHA8 = 0x8c43;
    public static final int GL_SRGB_ALPHA = 0x8c42;
    public static final int GL_SRGB_DECODE_ARB = 0x8299;
    public static final int GL_SRGB_READ = 0x8297;
    public static final int GL_SRGB_WRITE = 0x8298;
    public static final int GL_STACK_OVERFLOW = 0x503;
    public static final int GL_STACK_UNDERFLOW = 0x504;
    public static final int GL_STATIC_COPY = 0x88e6;
    public static final int GL_STATIC_DRAW = 0x88e4;
    public static final int GL_STATIC_READ = 0x88e5;
    public static final int GL_STENCIL = 0x1802;
    public static final int GL_STENCIL_ATTACHMENT = 0x8d20;
    public static final int GL_STENCIL_BACK_FAIL = 0x8801;
    public static final int GL_STENCIL_BACK_FUNC = 0x8800;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_FAIL = 0x8802;
    public static final int GL_STENCIL_BACK_PASS_DEPTH_PASS = 0x8803;
    public static final int GL_STENCIL_BACK_REF = 0x8ca3;
    public static final int GL_STENCIL_BACK_VALUE_MASK = 0x8ca4;
    public static final int GL_STENCIL_BACK_WRITEMASK = 0x8ca5;
    public static final int GL_STENCIL_BITS = 0xd57;
    public static final int GL_STENCIL_BUFFER_BIT = 0x400;
    public static final int GL_STENCIL_CLEAR_VALUE = 0xb91;
    public static final int GL_STENCIL_COMPONENTS = 0x8285;
    public static final int GL_STENCIL_FAIL = 0xb94;
    public static final int GL_STENCIL_FUNC = 0xb92;
    public static final int GL_STENCIL_INDEX = 0x1901;
    public static final int GL_STENCIL_INDEX1 = 0x8d46;
    public static final int GL_STENCIL_INDEX16 = 0x8d49;
    public static final int GL_STENCIL_INDEX4 = 0x8d47;
    public static final int GL_STENCIL_INDEX8 = 0x8d48;
    public static final int GL_STENCIL_PASS_DEPTH_FAIL = 0xb95;
    public static final int GL_STENCIL_PASS_DEPTH_PASS = 0xb96;
    public static final int GL_STENCIL_REF = 0xb97;
    public static final int GL_STENCIL_RENDERABLE = 0x8288;
    public static final int GL_STENCIL_TEST = 0xb90;
    public static final int GL_STENCIL_VALUE_MASK = 0xb93;
    public static final int GL_STENCIL_WRITEMASK = 0xb98;
    public static final int GL_STEREO = 0xc33;
    public static final int GL_STREAM_COPY = 0x88e2;
    public static final int GL_STREAM_DRAW = 0x88e0;
    public static final int GL_STREAM_READ = 0x88e1;
    public static final int GL_SUBPIXEL_BITS = 0xd50;
    public static final int GL_SYNC_CL_EVENT_ARB = 0x8240;
    public static final int GL_SYNC_CL_EVENT_COMPLETE_ARB = 0x8241;
    public static final int GL_SYNC_CONDITION = 0x9113;
    public static final int GL_SYNC_FENCE = 0x9116;
    public static final int GL_SYNC_FLAGS = 0x9115;
    public static final int GL_SYNC_FLUSH_COMMANDS_BIT = 0x1;
    public static final int GL_SYNC_GPU_COMMANDS_COMPLETE = 0x9117;
    public static final int GL_SYNC_STATUS = 0x9114;
    public static final int GL_T = 0x2001;
    public static final int GL_T2F_C3F_V3F = 0x2a2a;
    public static final int GL_T2F_C4F_N3F_V3F = 0x2a2c;
    public static final int GL_T2F_C4UB_V3F = 0x2a29;
    public static final int GL_T2F_N3F_V3F = 0x2a2b;
    public static final int GL_T2F_V3F = 0x2a27;
    public static final int GL_T4F_C4F_N3F_V4F = 0x2a2d;
    public static final int GL_T4F_V4F = 0x2a28;
    public static final int GL_TESS_CONTROL_OUTPUT_VERTICES = 0x8e75;
    public static final int GL_TESS_CONTROL_SHADER = 0x8e88;
    public static final int GL_TESS_CONTROL_SHADER_BIT = 0x8;
    public static final int GL_TESS_CONTROL_SHADER_PATCHES_ARB = 0x82f1;
    public static final int GL_TESS_CONTROL_SUBROUTINE = 0x92e9;
    public static final int GL_TESS_CONTROL_SUBROUTINE_UNIFORM = 0x92ef;
    public static final int GL_TESS_CONTROL_TEXTURE = 0x829c;
    public static final int GL_TESS_EVALUATION_SHADER = 0x8e87;
    public static final int GL_TESS_EVALUATION_SHADER_BIT = 0x10;
    public static final int GL_TESS_EVALUATION_SHADER_INVOCATIONS_ARB = 0x82f2;
    public static final int GL_TESS_EVALUATION_SUBROUTINE = 0x92ea;
    public static final int GL_TESS_EVALUATION_SUBROUTINE_UNIFORM = 0x92f0;
    public static final int GL_TESS_EVALUATION_TEXTURE = 0x829d;
    public static final int GL_TESS_GEN_MODE = 0x8e76;
    public static final int GL_TESS_GEN_POINT_MODE = 0x8e79;
    public static final int GL_TESS_GEN_SPACING = 0x8e77;
    public static final int GL_TESS_GEN_VERTEX_ORDER = 0x8e78;
    public static final int GL_TEXTURE = 0x1702;
    public static final int GL_TEXTURE0 = 0x84c0;
    public static final int GL_TEXTURE1 = 0x84c1;
    public static final int GL_TEXTURE10 = 0x84ca;
    public static final int GL_TEXTURE11 = 0x84cb;
    public static final int GL_TEXTURE12 = 0x84cc;
    public static final int GL_TEXTURE13 = 0x84cd;
    public static final int GL_TEXTURE14 = 0x84ce;
    public static final int GL_TEXTURE15 = 0x84cf;
    public static final int GL_TEXTURE16 = 0x84d0;
    public static final int GL_TEXTURE17 = 0x84d1;
    public static final int GL_TEXTURE18 = 0x84d2;
    public static final int GL_TEXTURE19 = 0x84d3;
    public static final int GL_TEXTURE2 = 0x84c2;
    public static final int GL_TEXTURE20 = 0x84d4;
    public static final int GL_TEXTURE21 = 0x84d5;
    public static final int GL_TEXTURE22 = 0x84d6;
    public static final int GL_TEXTURE23 = 0x84d7;
    public static final int GL_TEXTURE24 = 0x84d8;
    public static final int GL_TEXTURE25 = 0x84d9;
    public static final int GL_TEXTURE26 = 0x84da;
    public static final int GL_TEXTURE27 = 0x84db;
    public static final int GL_TEXTURE28 = 0x84dc;
    public static final int GL_TEXTURE29 = 0x84dd;
    public static final int GL_TEXTURE3 = 0x84c3;
    public static final int GL_TEXTURE30 = 0x84de;
    public static final int GL_TEXTURE31 = 0x84df;
    public static final int GL_TEXTURE4 = 0x84c4;
    public static final int GL_TEXTURE5 = 0x84c5;
    public static final int GL_TEXTURE6 = 0x84c6;
    public static final int GL_TEXTURE7 = 0x84c7;
    public static final int GL_TEXTURE8 = 0x84c8;
    public static final int GL_TEXTURE9 = 0x84c9;
    public static final int GL_TEXTURE_1D = 0xde0;
    public static final int GL_TEXTURE_1D_ARRAY = 0x8c18;
    public static final int GL_TEXTURE_2D = 0xde1;
    public static final int GL_TEXTURE_2D_ARRAY = 0x8c1a;
    public static final int GL_TEXTURE_2D_MULTISAMPLE = 0x9100;
    public static final int GL_TEXTURE_2D_MULTISAMPLE_ARRAY = 0x9102;
    public static final int GL_TEXTURE_3D = 0x806f;
    public static final int GL_TEXTURE_ALPHA_SIZE = 0x805f;
    public static final int GL_TEXTURE_ALPHA_TYPE = 0x8c13;
    public static final int GL_TEXTURE_BASE_LEVEL = 0x813c;
    public static final int GL_TEXTURE_BINDING_1D = 0x8068;
    public static final int GL_TEXTURE_BINDING_1D_ARRAY = 0x8c1c;
    public static final int GL_TEXTURE_BINDING_2D = 0x8069;
    public static final int GL_TEXTURE_BINDING_2D_ARRAY = 0x8c1d;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE = 0x9104;
    public static final int GL_TEXTURE_BINDING_2D_MULTISAMPLE_ARRAY = 0x9105;
    public static final int GL_TEXTURE_BINDING_3D = 0x806a;
    public static final int GL_TEXTURE_BINDING_BUFFER = 0x8c2c;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP = 0x8514;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY = 0x900a;
    public static final int GL_TEXTURE_BINDING_CUBE_MAP_ARRAY_ARB = 0x900a;
    public static final int GL_TEXTURE_BINDING_RECTANGLE = 0x84f6;
    public static final int GL_TEXTURE_BIT = 0x40000;
    public static final int GL_TEXTURE_BLUE_SIZE = 0x805e;
    public static final int GL_TEXTURE_BLUE_TYPE = 0x8c12;
    public static final int GL_TEXTURE_BORDER = 0x1005;
    public static final int GL_TEXTURE_BORDER_COLOR = 0x1004;
    public static final int GL_TEXTURE_BUFFER = 0x8c2a;
    public static final int GL_TEXTURE_BUFFER_BINDING = 0x8c2a;
    public static final int GL_TEXTURE_BUFFER_DATA_STORE_BINDING = 0x8c2d;
    public static final int GL_TEXTURE_BUFFER_OFFSET = 0x919d;
    public static final int GL_TEXTURE_BUFFER_OFFSET_ALIGNMENT = 0x919f;
    public static final int GL_TEXTURE_BUFFER_SIZE = 0x919e;
    public static final int GL_TEXTURE_COMPARE_FUNC = 0x884d;
    public static final int GL_TEXTURE_COMPARE_MODE = 0x884c;
    public static final int GL_TEXTURE_COMPRESSED = 0x86a1;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_HEIGHT = 0x82b2;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_SIZE = 0x82b3;
    public static final int GL_TEXTURE_COMPRESSED_BLOCK_WIDTH = 0x82b1;
    public static final int GL_TEXTURE_COMPRESSED_IMAGE_SIZE = 0x86a0;
    public static final int GL_TEXTURE_COMPRESSION_HINT = 0x84ef;
    public static final int GL_TEXTURE_COORD_ARRAY = 0x8078;
    public static final int GL_TEXTURE_COORD_ARRAY_COUNT_EXT = 0x808b;
    public static final int GL_TEXTURE_COORD_ARRAY_EXT = 0x8078;
    public static final int GL_TEXTURE_COORD_ARRAY_POINTER = 0x8092;
    public static final int GL_TEXTURE_COORD_ARRAY_POINTER_EXT = 0x8092;
    public static final int GL_TEXTURE_COORD_ARRAY_SIZE = 0x8088;
    public static final int GL_TEXTURE_COORD_ARRAY_SIZE_EXT = 0x8088;
    public static final int GL_TEXTURE_COORD_ARRAY_STRIDE = 0x808a;
    public static final int GL_TEXTURE_COORD_ARRAY_STRIDE_EXT = 0x808a;
    public static final int GL_TEXTURE_COORD_ARRAY_TYPE = 0x8089;
    public static final int GL_TEXTURE_COORD_ARRAY_TYPE_EXT = 0x8089;
    public static final int GL_TEXTURE_CUBE_MAP = 0x8513;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY = 0x9009;
    public static final int GL_TEXTURE_CUBE_MAP_ARRAY_ARB = 0x9009;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_X = 0x8516;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Y = 0x8518;
    public static final int GL_TEXTURE_CUBE_MAP_NEGATIVE_Z = 0x851a;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_X = 0x8515;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Y = 0x8517;
    public static final int GL_TEXTURE_CUBE_MAP_POSITIVE_Z = 0x8519;
    public static final int GL_TEXTURE_CUBE_MAP_SEAMLESS = 0x884f;
    public static final int GL_TEXTURE_DEPTH = 0x8071;
    public static final int GL_TEXTURE_DEPTH_SIZE = 0x884a;
    public static final int GL_TEXTURE_DEPTH_TYPE = 0x8c16;
    public static final int GL_TEXTURE_ENV = 0x2300;
    public static final int GL_TEXTURE_ENV_COLOR = 0x2201;
    public static final int GL_TEXTURE_ENV_MODE = 0x2200;
    public static final int GL_TEXTURE_FETCH_BARRIER_BIT = 0x8;
    public static final int GL_TEXTURE_FIXED_SAMPLE_LOCATIONS = 0x9107;
    public static final int GL_TEXTURE_GATHER = 0x82a2;
    public static final int GL_TEXTURE_GATHER_SHADOW = 0x82a3;
    public static final int GL_TEXTURE_GEN_MODE = 0x2500;
    public static final int GL_TEXTURE_GEN_Q = 0xc63;
    public static final int GL_TEXTURE_GEN_R = 0xc62;
    public static final int GL_TEXTURE_GEN_S = 0xc60;
    public static final int GL_TEXTURE_GEN_T = 0xc61;
    public static final int GL_TEXTURE_GREEN_SIZE = 0x805d;
    public static final int GL_TEXTURE_GREEN_TYPE = 0x8c11;
    public static final int GL_TEXTURE_HEIGHT = 0x1001;
    public static final int GL_TEXTURE_IMAGE_FORMAT = 0x828f;
    public static final int GL_TEXTURE_IMAGE_TYPE = 0x8290;
    public static final int GL_TEXTURE_IMMUTABLE_FORMAT = 0x912f;
    public static final int GL_TEXTURE_IMMUTABLE_LEVELS = 0x82df;
    public static final int GL_TEXTURE_INTENSITY_SIZE = 0x8061;
    public static final int GL_TEXTURE_INTERNAL_FORMAT = 0x1003;
    public static final int GL_TEXTURE_LOD_BIAS = 0x8501;
    public static final int GL_TEXTURE_LUMINANCE_SIZE = 0x8060;
    public static final int GL_TEXTURE_MAG_FILTER = 0x2800;
    public static final int GL_TEXTURE_MATRIX = 0xba8;
    public static final int GL_TEXTURE_MAX_LEVEL = 0x813d;
    public static final int GL_TEXTURE_MAX_LOD = 0x813b;
    public static final int GL_TEXTURE_MIN_FILTER = 0x2801;
    public static final int GL_TEXTURE_MIN_LOD = 0x813a;
    public static final int GL_TEXTURE_PRIORITY = 0x8066;
    public static final int GL_TEXTURE_RECTANGLE = 0x84f5;
    public static final int GL_TEXTURE_RED_SIZE = 0x805c;
    public static final int GL_TEXTURE_RED_TYPE = 0x8c10;
    public static final int GL_TEXTURE_RESIDENT = 0x8067;
    public static final int GL_TEXTURE_SAMPLES = 0x9106;
    public static final int GL_TEXTURE_SHADOW = 0x82a1;
    public static final int GL_TEXTURE_SHARED_SIZE = 0x8c3f;
    public static final int GL_TEXTURE_SPARSE_ARB = 0x91a6;
    public static final int GL_TEXTURE_STACK_DEPTH = 0xba5;
    public static final int GL_TEXTURE_STENCIL_SIZE = 0x88f1;
    public static final int GL_TEXTURE_SWIZZLE_A = 0x8e45;
    public static final int GL_TEXTURE_SWIZZLE_B = 0x8e44;
    public static final int GL_TEXTURE_SWIZZLE_G = 0x8e43;
    public static final int GL_TEXTURE_SWIZZLE_R = 0x8e42;
    public static final int GL_TEXTURE_SWIZZLE_RGBA = 0x8e46;
    public static final int GL_TEXTURE_TARGET = 0x1006;
    public static final int GL_TEXTURE_UPDATE_BARRIER_BIT = 0x100;
    public static final int GL_TEXTURE_VIEW = 0x82b5;
    public static final int GL_TEXTURE_VIEW_MIN_LAYER = 0x82dd;
    public static final int GL_TEXTURE_VIEW_MIN_LEVEL = 0x82db;
    public static final int GL_TEXTURE_VIEW_NUM_LAYERS = 0x82de;
    public static final int GL_TEXTURE_VIEW_NUM_LEVELS = 0x82dc;
    public static final int GL_TEXTURE_WIDTH = 0x1000;
    public static final int GL_TEXTURE_WRAP_R = 0x8072;
    public static final int GL_TEXTURE_WRAP_S = 0x2802;
    public static final int GL_TEXTURE_WRAP_T = 0x2803;
    public static final int GL_TIMEOUT_EXPIRED = 0x911b;
    public static final int GL_TIMESTAMP = 0x8e28;
    public static final int GL_TIME_ELAPSED = 0x88bf;
    public static final int GL_TOP_LEVEL_ARRAY_SIZE = 0x930c;
    public static final int GL_TOP_LEVEL_ARRAY_STRIDE = 0x930d;
    public static final int GL_TRANSFORM_BIT = 0x1000;
    public static final int GL_TRANSFORM_FEEDBACK = 0x8e22;
    public static final int GL_TRANSFORM_FEEDBACK_ACTIVE = 0x8e24;
    public static final int GL_TRANSFORM_FEEDBACK_BARRIER_BIT = 0x800;
    public static final int GL_TRANSFORM_FEEDBACK_BINDING = 0x8e25;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER = 0x8c8e;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_ACTIVE = 0x8e24;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_BINDING = 0x8c8f;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_INDEX = 0x934b;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_MODE = 0x8c7f;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_PAUSED = 0x8e23;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_SIZE = 0x8c85;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_START = 0x8c84;
    public static final int GL_TRANSFORM_FEEDBACK_BUFFER_STRIDE = 0x934c;
    public static final int GL_TRANSFORM_FEEDBACK_OVERFLOW_ARB = 0x82ec;
    public static final int GL_TRANSFORM_FEEDBACK_PAUSED = 0x8e23;
    public static final int GL_TRANSFORM_FEEDBACK_PRIMITIVES_WRITTEN = 0x8c88;
    public static final int GL_TRANSFORM_FEEDBACK_STREAM_OVERFLOW_ARB = 0x82ed;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING = 0x92f4;
    public static final int GL_TRANSFORM_FEEDBACK_VARYINGS = 0x8c83;
    public static final int GL_TRANSFORM_FEEDBACK_VARYING_MAX_LENGTH = 0x8c76;
    public static final int GL_TRIANGLES = 0x4;
    public static final int GL_TRIANGLES_ADJACENCY = 0xc;
    public static final int GL_TRIANGLE_FAN = 0x6;
    public static final int GL_TRIANGLE_STRIP = 0x5;
    public static final int GL_TRIANGLE_STRIP_ADJACENCY = 0xd;
    public static final int GL_TRUE = 0x1;
    public static final int GL_TYPE = 0x92fa;
    public static final int GL_UNDEFINED_VERTEX = 0x8260;
    public static final int GL_UNIFORM = 0x92e1;
    public static final int GL_UNIFORM_ARRAY_STRIDE = 0x8a3c;
    public static final int GL_UNIFORM_ATOMIC_COUNTER_BUFFER_INDEX = 0x92da;
    public static final int GL_UNIFORM_BARRIER_BIT = 0x4;
    public static final int GL_UNIFORM_BLOCK = 0x92e2;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORMS = 0x8a42;
    public static final int GL_UNIFORM_BLOCK_ACTIVE_UNIFORM_INDICES = 0x8a43;
    public static final int GL_UNIFORM_BLOCK_BINDING = 0x8a3f;
    public static final int GL_UNIFORM_BLOCK_DATA_SIZE = 0x8a40;
    public static final int GL_UNIFORM_BLOCK_INDEX = 0x8a3a;
    public static final int GL_UNIFORM_BLOCK_NAME_LENGTH = 0x8a41;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_COMPUTE_SHADER = 0x90ec;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_FRAGMENT_SHADER = 0x8a46;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_GEOMETRY_SHADER = 0x8a45;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_CONTROL_SHADER = 0x84f0;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_TESS_EVALUATION_SHADER = 0x84f1;
    public static final int GL_UNIFORM_BLOCK_REFERENCED_BY_VERTEX_SHADER = 0x8a44;
    public static final int GL_UNIFORM_BUFFER = 0x8a11;
    public static final int GL_UNIFORM_BUFFER_BINDING = 0x8a28;
    public static final int GL_UNIFORM_BUFFER_OFFSET_ALIGNMENT = 0x8a34;
    public static final int GL_UNIFORM_BUFFER_SIZE = 0x8a2a;
    public static final int GL_UNIFORM_BUFFER_START = 0x8a29;
    public static final int GL_UNIFORM_IS_ROW_MAJOR = 0x8a3e;
    public static final int GL_UNIFORM_MATRIX_STRIDE = 0x8a3d;
    public static final int GL_UNIFORM_NAME_LENGTH = 0x8a39;
    public static final int GL_UNIFORM_OFFSET = 0x8a3b;
    public static final int GL_UNIFORM_SIZE = 0x8a38;
    public static final int GL_UNIFORM_TYPE = 0x8a37;
    public static final int GL_UNKNOWN_CONTEXT_RESET = 0x8255;
    public static final int GL_UNKNOWN_CONTEXT_RESET_ARB = 0x8255;
    public static final int GL_UNPACK_ALIGNMENT = 0xcf5;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_DEPTH = 0x9129;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_HEIGHT = 0x9128;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_SIZE = 0x912a;
    public static final int GL_UNPACK_COMPRESSED_BLOCK_WIDTH = 0x9127;
    public static final int GL_UNPACK_IMAGE_HEIGHT = 0x806e;
    public static final int GL_UNPACK_LSB_FIRST = 0xcf1;
    public static final int GL_UNPACK_ROW_LENGTH = 0xcf2;
    public static final int GL_UNPACK_SKIP_IMAGES = 0x806d;
    public static final int GL_UNPACK_SKIP_PIXELS = 0xcf4;
    public static final int GL_UNPACK_SKIP_ROWS = 0xcf3;
    public static final int GL_UNPACK_SWAP_BYTES = 0xcf0;
    public static final int GL_UNSIGNALED = 0x9118;
    public static final int GL_UNSIGNED_BYTE = 0x1401;
    public static final int GL_UNSIGNED_BYTE_2_3_3_REV = 0x8362;
    public static final int GL_UNSIGNED_BYTE_3_3_2 = 0x8032;
    public static final int GL_UNSIGNED_INT = 0x1405;
    public static final int GL_UNSIGNED_INT64_ARB = 0x140f;
    public static final int GL_UNSIGNED_INT_10F_11F_11F_REV = 0x8c3b;
    public static final int GL_UNSIGNED_INT_10_10_10_2 = 0x8036;
    public static final int GL_UNSIGNED_INT_24_8 = 0x84fa;
    public static final int GL_UNSIGNED_INT_2_10_10_10_REV = 0x8368;
    public static final int GL_UNSIGNED_INT_5_9_9_9_REV = 0x8c3e;
    public static final int GL_UNSIGNED_INT_8_8_8_8 = 0x8035;
    public static final int GL_UNSIGNED_INT_8_8_8_8_REV = 0x8367;
    public static final int GL_UNSIGNED_INT_ATOMIC_COUNTER = 0x92db;
    public static final int GL_UNSIGNED_INT_IMAGE_1D = 0x9062;
    public static final int GL_UNSIGNED_INT_IMAGE_1D_ARRAY = 0x9068;
    public static final int GL_UNSIGNED_INT_IMAGE_2D = 0x9063;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_ARRAY = 0x9069;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE = 0x906b;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_MULTISAMPLE_ARRAY = 0x906c;
    public static final int GL_UNSIGNED_INT_IMAGE_2D_RECT = 0x9065;
    public static final int GL_UNSIGNED_INT_IMAGE_3D = 0x9064;
    public static final int GL_UNSIGNED_INT_IMAGE_BUFFER = 0x9067;
    public static final int GL_UNSIGNED_INT_IMAGE_CUBE = 0x9066;
    public static final int GL_UNSIGNED_INT_IMAGE_CUBE_MAP_ARRAY = 0x906a;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D = 0x8dd1;
    public static final int GL_UNSIGNED_INT_SAMPLER_1D_ARRAY = 0x8dd6;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D = 0x8dd2;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_ARRAY = 0x8dd7;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE = 0x910a;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_MULTISAMPLE_ARRAY = 0x910d;
    public static final int GL_UNSIGNED_INT_SAMPLER_2D_RECT = 0x8dd5;
    public static final int GL_UNSIGNED_INT_SAMPLER_3D = 0x8dd3;
    public static final int GL_UNSIGNED_INT_SAMPLER_BUFFER = 0x8dd8;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE = 0x8dd4;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY = 0x900f;
    public static final int GL_UNSIGNED_INT_SAMPLER_CUBE_MAP_ARRAY_ARB = 0x900f;
    public static final int GL_UNSIGNED_INT_VEC2 = 0x8dc6;
    public static final int GL_UNSIGNED_INT_VEC3 = 0x8dc7;
    public static final int GL_UNSIGNED_INT_VEC4 = 0x8dc8;
    public static final int GL_UNSIGNED_NORMALIZED = 0x8c17;
    public static final int GL_UNSIGNED_SHORT = 0x1403;
    public static final int GL_UNSIGNED_SHORT_1_5_5_5_REV = 0x8366;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4 = 0x8033;
    public static final int GL_UNSIGNED_SHORT_4_4_4_4_REV = 0x8365;
    public static final int GL_UNSIGNED_SHORT_5_5_5_1 = 0x8034;
    public static final int GL_UNSIGNED_SHORT_5_6_5 = 0x8363;
    public static final int GL_UNSIGNED_SHORT_5_6_5_REV = 0x8364;
    public static final int GL_UPPER_LEFT = 0x8ca2;
    public static final int GL_V2F = 0x2a20;
    public static final int GL_V3F = 0x2a21;
    public static final int GL_VALIDATE_STATUS = 0x8b83;
    public static final int GL_VENDOR = 0x1f00;
    public static final int GL_VERSION = 0x1f02;
    public static final int GL_VERSION_1_0 = 0x1;
    public static final int GL_VERSION_1_1 = 0x1;
    public static final int GL_VERSION_1_2 = 0x1;
    public static final int GL_VERSION_1_3 = 0x1;
    public static final int GL_VERSION_1_4 = 0x1;
    public static final int GL_VERSION_1_5 = 0x1;
    public static final int GL_VERSION_2_0 = 0x1;
    public static final int GL_VERSION_2_1 = 0x1;
    public static final int GL_VERSION_3_0 = 0x1;
    public static final int GL_VERSION_3_1 = 0x1;
    public static final int GL_VERSION_3_2 = 0x1;
    public static final int GL_VERSION_3_3 = 0x1;
    public static final int GL_VERSION_4_0 = 0x1;
    public static final int GL_VERSION_4_1 = 0x1;
    public static final int GL_VERSION_4_2 = 0x1;
    public static final int GL_VERSION_4_3 = 0x1;
    public static final int GL_VERSION_4_4 = 0x1;
    public static final int GL_VERSION_4_5 = 0x1;
    public static final int GL_VERTEX_ARRAY = 0x8074;
    public static final int GL_VERTEX_ARRAY_BINDING = 0x85b5;
    public static final int GL_VERTEX_ARRAY_COUNT_EXT = 0x807d;
    public static final int GL_VERTEX_ARRAY_EXT = 0x8074;
    public static final int GL_VERTEX_ARRAY_POINTER = 0x808e;
    public static final int GL_VERTEX_ARRAY_POINTER_EXT = 0x808e;
    public static final int GL_VERTEX_ARRAY_SIZE = 0x807a;
    public static final int GL_VERTEX_ARRAY_SIZE_EXT = 0x807a;
    public static final int GL_VERTEX_ARRAY_STRIDE = 0x807c;
    public static final int GL_VERTEX_ARRAY_STRIDE_EXT = 0x807c;
    public static final int GL_VERTEX_ARRAY_TYPE = 0x807b;
    public static final int GL_VERTEX_ARRAY_TYPE_EXT = 0x807b;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BARRIER_BIT = 0x1;
    public static final int GL_VERTEX_ATTRIB_ARRAY_BUFFER_BINDING = 0x889f;
    public static final int GL_VERTEX_ATTRIB_ARRAY_DIVISOR = 0x88fe;
    public static final int GL_VERTEX_ATTRIB_ARRAY_ENABLED = 0x8622;
    public static final int GL_VERTEX_ATTRIB_ARRAY_INTEGER = 0x88fd;
    public static final int GL_VERTEX_ATTRIB_ARRAY_LONG = 0x874e;
    public static final int GL_VERTEX_ATTRIB_ARRAY_NORMALIZED = 0x886a;
    public static final int GL_VERTEX_ATTRIB_ARRAY_POINTER = 0x8645;
    public static final int GL_VERTEX_ATTRIB_ARRAY_SIZE = 0x8623;
    public static final int GL_VERTEX_ATTRIB_ARRAY_STRIDE = 0x8624;
    public static final int GL_VERTEX_ATTRIB_ARRAY_TYPE = 0x8625;
    public static final int GL_VERTEX_ATTRIB_BINDING = 0x82d4;
    public static final int GL_VERTEX_ATTRIB_RELATIVE_OFFSET = 0x82d5;
    public static final int GL_VERTEX_BINDING_BUFFER = 0x8f4f;
    public static final int GL_VERTEX_BINDING_DIVISOR = 0x82d6;
    public static final int GL_VERTEX_BINDING_OFFSET = 0x82d7;
    public static final int GL_VERTEX_BINDING_STRIDE = 0x82d8;
    public static final int GL_VERTEX_PROGRAM_POINT_SIZE = 0x8642;
    public static final int GL_VERTEX_SHADER = 0x8b31;
    public static final int GL_VERTEX_SHADER_BIT = 0x1;
    public static final int GL_VERTEX_SHADER_INVOCATIONS_ARB = 0x82f0;
    public static final int GL_VERTEX_SUBROUTINE = 0x92e8;
    public static final int GL_VERTEX_SUBROUTINE_UNIFORM = 0x92ee;
    public static final int GL_VERTEX_TEXTURE = 0x829b;
    public static final int GL_VERTICES_SUBMITTED_ARB = 0x82ee;
    public static final int GL_VIEWPORT = 0xba2;
    public static final int GL_VIEWPORT_BIT = 0x800;
    public static final int GL_VIEWPORT_BOUNDS_RANGE = 0x825d;
    public static final int GL_VIEWPORT_INDEX_PROVOKING_VERTEX = 0x825f;
    public static final int GL_VIEWPORT_SUBPIXEL_BITS = 0x825c;
    public static final int GL_VIEW_CLASS_128_BITS = 0x82c4;
    public static final int GL_VIEW_CLASS_16_BITS = 0x82ca;
    public static final int GL_VIEW_CLASS_24_BITS = 0x82c9;
    public static final int GL_VIEW_CLASS_32_BITS = 0x82c8;
    public static final int GL_VIEW_CLASS_48_BITS = 0x82c7;
    public static final int GL_VIEW_CLASS_64_BITS = 0x82c6;
    public static final int GL_VIEW_CLASS_8_BITS = 0x82cb;
    public static final int GL_VIEW_CLASS_96_BITS = 0x82c5;
    public static final int GL_VIEW_CLASS_BPTC_FLOAT = 0x82d3;
    public static final int GL_VIEW_CLASS_BPTC_UNORM = 0x82d2;
    public static final int GL_VIEW_CLASS_RGTC1_RED = 0x82d0;
    public static final int GL_VIEW_CLASS_RGTC2_RG = 0x82d1;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGB = 0x82cc;
    public static final int GL_VIEW_CLASS_S3TC_DXT1_RGBA = 0x82cd;
    public static final int GL_VIEW_CLASS_S3TC_DXT3_RGBA = 0x82ce;
    public static final int GL_VIEW_CLASS_S3TC_DXT5_RGBA = 0x82cf;
    public static final int GL_VIEW_COMPATIBILITY_CLASS = 0x82b6;
    public static final int GL_VIRTUAL_PAGE_SIZE_INDEX_ARB = 0x91a7;
    public static final int GL_VIRTUAL_PAGE_SIZE_X_ARB = 0x9195;
    public static final int GL_VIRTUAL_PAGE_SIZE_Y_ARB = 0x9196;
    public static final int GL_VIRTUAL_PAGE_SIZE_Z_ARB = 0x9197;
    public static final int GL_WAIT_FAILED = 0x911d;
    public static final int GL_WRITE_ONLY = 0x88b9;
    public static final int GL_XOR = 0x1506;
    public static final int GL_ZERO = 0x0;
    public static final int GL_ZERO_TO_ONE = 0x935f;
    public static final int GL_ZOOM_X = 0xd16;
    public static final int GL_ZOOM_Y = 0xd17;

    private static GraphicsContext context;
    public static void init(GraphicsContext context) {
        OpenGL.context = context;
    }

    private static GraphicsContext getContext() {
        if (context == null) {
            throw new IllegalStateException("OpenGL implementation not initialized yet, did you create a context?");
        }
        return context;
    }

    private static final FunctionDescriptor glClearDescriptor = FunctionDescriptor.ofVoid(GLbitfield);
    public static void glClear(int mask) {
        try {
            getContext().getMethodHandle("glClear", glClearDescriptor).invokeExact(mask);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glClearColorDescriptor = FunctionDescriptor.ofVoid(GLfloat, GLfloat, GLfloat, GLfloat);
    public static void glClearColor(float red, float green, float blue, float alpha) {
        try {
            getContext().getMethodHandle("glClearColor", glClearColorDescriptor).invokeExact(red, green, blue, alpha);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glCreateShaderDescriptor = FunctionDescriptor.of(GLuint, GLenum);
    public static int glCreateShader(int type) {
        try {
            return (int) getContext().getMethodHandle("glCreateShader", glCreateShaderDescriptor).invokeExact(type);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glShaderSourceDescriptor = FunctionDescriptor.ofVoid(GLuint, GLsizei, POINTER, POINTER);
    public static void glShaderSource(int shader, int count, MemorySegment string, MemorySegment length) {
        try {
            getContext().getMethodHandle("glShaderSource", glShaderSourceDescriptor).invokeExact(shader, count, string, length);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glShaderSource(int shader, String string) {
        try(var arena = Arena.ofConfined()) {
            MemorySegment stringPointer = arena.allocateFrom(POINTER, arena.allocateFrom(string));
            glShaderSource(shader, 1, stringPointer, MemorySegment.NULL);
        }
    }

    private static final FunctionDescriptor glCompileShaderDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glCompileShader(int shader) {
        try {
            getContext().getMethodHandle("glCompileShader", glCompileShaderDescriptor).invokeExact(shader);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glCreateProgramDescriptor = FunctionDescriptor.of(GLuint);
    public static int glCreateProgram() {
        try {
            return (int) getContext().getMethodHandle("glCreateProgram", glCreateProgramDescriptor).invokeExact();
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glAttachShaderDescriptor = FunctionDescriptor.ofVoid(GLuint, GLuint);
    public static void glAttachShader(int program, int shader) {
        try {
            getContext().getMethodHandle("glAttachShader", glAttachShaderDescriptor).invokeExact(program, shader);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glLinkProgramDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glLinkProgram(int program) {
        try {
            getContext().getMethodHandle("glLinkProgram", glLinkProgramDescriptor).invokeExact(program);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glDeleteShaderDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glDeleteShader(int shader) {
        try {
            getContext().getMethodHandle("glDeleteShader", glDeleteShaderDescriptor).invokeExact(shader);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glGenVertexArraysDescriptor = FunctionDescriptor.ofVoid(GLsizei, POINTER);
    public static void glGenVertexArrays(int n, MemorySegment arrays) {
        try {
            getContext().getMethodHandle("glGenVertexArrays", glGenVertexArraysDescriptor).invokeExact(n, arrays);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int glGenVertexArrays() {
        try(var arena = Arena.ofConfined()) {
            MemorySegment array = arena.allocate(GLuint);
            glGenVertexArrays(1, array);
            return array.get(GLuint, 0);
        }
    }

    private static final FunctionDescriptor glGenBuffersDescriptor = FunctionDescriptor.ofVoid(GLsizei, POINTER);
    public static void glGenBuffers(int n, MemorySegment buffers) {
        try {
            getContext().getMethodHandle("glGenBuffers", glGenBuffersDescriptor).invokeExact(n, buffers);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int glGenBuffers() {
        try(var arena = Arena.ofConfined()) {
            MemorySegment buffer = arena.allocateFrom(POINTER, arena.allocateFrom(GLuint));
            glGenBuffers(1, buffer);
            return buffer.get(GLuint, 0);
        }
    }

    private static final FunctionDescriptor glBindVertexArrayDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glBindVertexArray(int array) {
        try {
            getContext().getMethodHandle("glBindVertexArray", glBindVertexArrayDescriptor).invokeExact(array);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glVertexAttribPointerDescriptor = FunctionDescriptor.ofVoid(GLuint , GLint, GLenum, GLboolean, GLsizei, POINTER);
    public static void glVertexAttribPointer(int index, int size, int type, boolean normalized, int stride, MemorySegment pointer) {
        try {
            getContext().getMethodHandle("glVertexAttribPointer", glVertexAttribPointerDescriptor).invokeExact(index, size, type, normalized, stride, pointer);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glEnableVertexAttribArrayDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glEnableVertexAttribArray(int index) {
        try {
            getContext().getMethodHandle("glEnableVertexAttribArray", glEnableVertexAttribArrayDescriptor).invokeExact(index);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glBindBufferDescriptor = FunctionDescriptor.ofVoid(GLenum, GLuint);
    public static void glBindBuffer(int target, int buffer) {
        try {
            getContext().getMethodHandle("glBindBuffer", glBindBufferDescriptor).invokeExact(target, buffer);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glBufferDataDescriptor = FunctionDescriptor.ofVoid(GLenum , GLsizeiptr, POINTER, GLenum);
    public static void glBufferData(int target, int size, MemorySegment data, int usage) {
        try {
            getContext().getMethodHandle("glBufferData", glBufferDataDescriptor).invokeExact(target, size, data, usage);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glBufferData(int target, float[] data, int usage) {
        try(var arena = Arena.ofConfined()) {
            glBufferData(target, data.length * Float.BYTES, arena.allocateFrom(GLfloat, data), usage);
        }
    }

    public static void glBufferData(int target, int[] data, int usage) {
        try(var arena = Arena.ofConfined()) {
            glBufferData(target, data.length * Integer.BYTES, arena.allocateFrom(GLint, data), usage);
        }
    }

    private static final FunctionDescriptor glUseProgramDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glUseProgram(int program) {
        try {
            getContext().getMethodHandle("glUseProgram", glUseProgramDescriptor).invokeExact(program);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glDrawElementsDescriptor = FunctionDescriptor.ofVoid(GLenum , GLsizei, GLenum , POINTER);
    public static void glDrawElements(int mode, int count, int type, MemorySegment indices) {
        try {
            getContext().getMethodHandle("glDrawElements", glDrawElementsDescriptor).invokeExact(mode, count, type, indices);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glDeleteVertexArraysDescriptor = FunctionDescriptor.ofVoid(GLsizei, POINTER);
    public static void glDeleteVertexArrays(int n, MemorySegment arrays) {
        try {
            getContext().getMethodHandle("glDeleteVertexArrays", glDeleteVertexArraysDescriptor).invokeExact(n, arrays);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glDeleteVertexArrays(int array) {
        try(var arena = Arena.ofConfined()) {
            glDeleteVertexArrays(1, arena.allocateFrom(GLuint, array));
        }

    }

    private static final FunctionDescriptor glDeleteBuffersDescriptor = FunctionDescriptor.ofVoid(GLsizei, POINTER);
    public static void glDeleteBuffers(int n, MemorySegment buffers) {
        try {
            getContext().getMethodHandle("glDeleteBuffers", glDeleteBuffersDescriptor).invokeExact(n, buffers);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glDeleteBuffers(int buffer) {
        try(var arena = Arena.ofConfined()) {
            glDeleteBuffers(1, arena.allocateFrom(GLuint, buffer));
        }
    }

    private static final FunctionDescriptor glDeleteProgramDescriptor = FunctionDescriptor.ofVoid(GLuint);
    public static void glDeleteProgram(int program) {
        try {
            getContext().getMethodHandle("glDeleteProgram", glDeleteProgramDescriptor).invokeExact(program);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glGetShaderivDescriptor = FunctionDescriptor.ofVoid(GLuint, GLenum, POINTER);
    public static void glGetShaderiv(int shader, int pname, MemorySegment params) {
        try {
            getContext().getMethodHandle("glGetShaderiv", glGetShaderivDescriptor).invokeExact(shader, pname, params);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean glGetShaderCompileStatus(int shader) {
        try(var arena = Arena.ofConfined()) {
            MemorySegment success = arena.allocate(GLint);
            glGetShaderiv(shader, GL_COMPILE_STATUS, success);
            return success.get(GLint, 0) != 0;
        }
    }

    private static final FunctionDescriptor glGetShaderInfoLogDescriptor = FunctionDescriptor.ofVoid(GLuint, GLsizei, POINTER, POINTER);
    public static void glGetShaderInfoLog(int shader, int maxLength, MemorySegment length, MemorySegment infoLog) {
        try {
            getContext().getMethodHandle("glGetShaderInfoLog", glGetShaderInfoLogDescriptor).invokeExact(shader, maxLength, length, infoLog);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String glGetShaderInfoLog(int shader, int maxLength) {
        try(var arena = Arena.ofConfined()) {
            MemorySegment infoLog = arena.allocateFrom(GLchar, new byte[maxLength]);
            glGetShaderInfoLog(shader, maxLength, arena.allocateFrom(GLsizei, 0), infoLog);
            return infoLog.getString(0);
        }
    }

    private static final FunctionDescriptor glGetProgramivDescriptor = FunctionDescriptor.ofVoid(GLuint, GLenum, POINTER);
    public static void glGetProgramiv(int program, int pname, MemorySegment params) {
        try {
            getContext().getMethodHandle("glGetProgramiv", glGetProgramivDescriptor).invokeExact(program, pname, params);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean glGetProgramLinkStatus(int program) {
        try(var arena = Arena.ofConfined()) {
            MemorySegment success = arena.allocate(GLint);
            glGetProgramiv(program, GL_LINK_STATUS, success);
            return success.get(GLint, 0) != 0;
        }
    }

    private static final FunctionDescriptor glGetProgramInfoLogDescriptor = FunctionDescriptor.ofVoid(GLuint, GLuint, POINTER, POINTER);
    public static void glGetProgramInfoLog(int program, int maxLength, MemorySegment length, MemorySegment infoLog) {
        try {
            getContext().getMethodHandle("glGetProgramInfoLog", glGetProgramInfoLogDescriptor).invokeExact(program, maxLength, length, infoLog);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static String glGetProgramInfoLog(int program, int maxLength) {
        try(var arena = Arena.ofConfined()) {
            MemorySegment infoLog = arena.allocateFrom(GLchar, new byte[maxLength]);
            glGetProgramInfoLog(program, maxLength, arena.allocateFrom(GLsizei, 0), infoLog);
            return infoLog.getString(0);
        }
    }

    private static final FunctionDescriptor glViewportDescriptor = FunctionDescriptor.ofVoid(GLint, GLint, GLsizei, GLsizei);
    public static void glViewport(int x, int y, int width, int height) {
        try {
            getContext().getMethodHandle("glViewport", glViewportDescriptor).invokeExact(x, y, width, height);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glGenTexturesDescriptor = FunctionDescriptor.ofVoid(GLsizei, POINTER);
    public static void glGenTextures(int n, MemorySegment textures) {
        try {
            getContext().getMethodHandle("glGenTextures", glGenTexturesDescriptor).invokeExact(n, textures);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int glGenTextures() {
        try(var arena = Arena.ofConfined()) {
            MemorySegment buffer = arena.allocateFrom(POINTER, arena.allocateFrom(GLuint));
            glGenTextures(1, buffer);
            return buffer.get(GLuint, 0);
        }
    }

    private static final FunctionDescriptor glTexImage2DDescriptor = FunctionDescriptor.ofVoid(GLenum, GLint, GLint, GLsizei, GLsizei, GLint, GLenum, GLenum, POINTER);
    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, MemorySegment data) {
        try {
            getContext().getMethodHandle("glTexImage2D", glTexImage2DDescriptor).invokeExact(target, level, internalformat, width, height, border, format, type, data);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glTexImage2D(int target, int level, int internalformat, int width, int height, int border, int format, int type, byte[] data) {
        try(var arena = Arena.ofConfined()) {
            glTexImage2D(target, level, internalformat, width, height, border, format, type, arena.allocateFrom(GLbyte, data));
        }
    }

    private static final FunctionDescriptor glTexParameteriDescriptor = FunctionDescriptor.ofVoid(GLenum, GLenum, GLint);
    public static void glTexParameteri(int target, int pname, int param) {
        try {
            getContext().getMethodHandle("glTexParameteri", glTexParameteriDescriptor).invokeExact(target, pname, param);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glBindTextureDescriptor = FunctionDescriptor.ofVoid(GLenum, GLuint);
    public static void glBindTexture(int target, int texture) {
        try {
            getContext().getMethodHandle("glBindTexture", glBindTextureDescriptor).invokeExact(target, texture);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glGetUniformLocationDescriptor = FunctionDescriptor.of(GLint, GLuint, POINTER);
    public static int glGetUniformLocation(int program, MemorySegment name) {
        try {
            return (int) getContext().getMethodHandle("glGetUniformLocation", glGetUniformLocationDescriptor).invokeExact(program, name);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static int glGetUniformLocation(int program, String name) {
        try(var arena = Arena.ofConfined()) {
            return glGetUniformLocation(program, arena.allocateFrom(name));
        }
    }

    private static final FunctionDescriptor glUniformMatrix4fvDescriptor = FunctionDescriptor.ofVoid(GLint, GLsizei, GLboolean, POINTER);
    public static void glUniformMatrix4fv(int location, int count, boolean transpose, MemorySegment value) {
        try {
            getContext().getMethodHandle("glUniformMatrix4fv", glUniformMatrix4fvDescriptor).invokeExact(location, count, transpose, value);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public static void glUniformMatrix4fv(int location, int count, boolean transpose, float[] value) {
        try(var arena = Arena.ofConfined()) {
            glUniformMatrix4fv(location, count, transpose, arena.allocateFrom(GLfloat, value));
        }
    }

    private static final FunctionDescriptor glUniform4fDescriptor = FunctionDescriptor.ofVoid(GLint, GLfloat, GLfloat, GLfloat, GLfloat);
    public static void glUniform4f(int location, float v0, float v1, float v2, float v3) {
        try {
            getContext().getMethodHandle("glUniform4f", glUniform4fDescriptor).invokeExact(location, v0, v1, v2, v3);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glActiveTextureDescriptor = FunctionDescriptor.ofVoid(GLenum);
    public static void glActiveTexture(int texture) {
        try {
            getContext().getMethodHandle("glActiveTexture", glActiveTextureDescriptor).invokeExact(texture);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glDrawArraysDescriptor = FunctionDescriptor.ofVoid(GLenum, GLint, GLsizei);
    public static void glDrawArrays(int mode, int first, int count) {
        try {
            getContext().getMethodHandle("glDrawArrays", glDrawArraysDescriptor).invokeExact(mode, first, count);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static final FunctionDescriptor glUniform1iDescriptor = FunctionDescriptor.ofVoid(GLint, GLint);
    public static void glUniform1i(int location, int v0) {
        try {
            getContext().getMethodHandle("glUniform1i", glUniform1iDescriptor).invokeExact(location, v0);
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
