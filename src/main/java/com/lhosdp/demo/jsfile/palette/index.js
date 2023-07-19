import PaletteModule from '../../../diagram-js/features/palette';
import CreateModule from '../../../diagram-js/features/create';
import SpaceToolModule from '../../../diagram-js/features/space-tool';
import LassoToolModule from '../../../diagram-js/features/lasso-tool';
import HandToolModule from '../../../diagram-js/features/hand-tool';
import GlobalConnectModule from '../../../diagram-js/features/global-connect';
import translate from '../../../diagram-js/i18n/translate';

import PaletteProvider from './PaletteProvider';

export default {
  __depends__: [
    PaletteModule,
    CreateModule,
    SpaceToolModule,
    LassoToolModule,
    HandToolModule,
    GlobalConnectModule,
    translate
  ],
  __init__: [ 'paletteProvider' ],
  paletteProvider: [ 'type', PaletteProvider ]
};
